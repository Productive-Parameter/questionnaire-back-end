package productiveparameter.Kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import productiveparameter.Kyselypalvelu.domain.Kysely;
import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;
import productiveparameter.Kyselypalvelu.domain.MonivalintaVaihtoehto;
import productiveparameter.Kyselypalvelu.domain.MonivalintaVaihtoehtoRepo;

@CrossOrigin(origins = "*")
@Controller
public class KysymysController {

	@Autowired
	private KyselyRepo kyselyrepo;

	@Autowired
	private KysymysRepo kysymysrepo;

	@Autowired
	private MonivalintaVaihtoehtoRepo monivalintarepo;

	/************ RESTFUL SERVICES ***************/
	// 2. REST --> hakee kaikki kysymykset osoitteeseen http://localhost:8080/words
	@RequestMapping(value = "/api/kysymykset", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> kysymyslistaRest() {
		return (List<Kysymys>) kysymysrepo.findAll();
	}

	// 3. REST --> hakee kysymyksiä id:n avulla
	@RequestMapping(value = "/api/kysymykset/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysid") Long Id) {
		return kysymysrepo.findById(Id);
	}

	// 4. REST --> hakee tietyn kyselyn kysymykset kysely id:n avulla
	@RequestMapping(value = "/api/kysymykset/kysely/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> findKysymyksetByKyselyId(@PathVariable("id") Long id) {
		Kysely kysely = kyselyrepo.findById(id).get();
		return kysely.getKysymykset();
	}

	/*******************************************/

	// 4. Uuden kysymyksen lisääminen HUOM!!!!!!!!!!! Ei käytetä tällä hetkellä
	@RequestMapping(value = "/kysymys/lisaa")
	public String lisaaKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		model.addAttribute("kyselyt", kyselyrepo.findAll());
		return "lisaakysymys";
	}

	// 5. Tallenna kysymys HUOM!!!!!!!!!!! Ei käytetä tällä hetkellä
	@RequestMapping(value = "/kysymys/tallenna", method = RequestMethod.POST)
	public String tallennaKysymys(Kysymys kysymys) {
		kysymysrepo.save(kysymys);
		return "redirect:lisaakysymys";
	}

	// 6. Lisää vaihtoehdot monivalintakysymyksiin
	@RequestMapping(value = "/kysymys/{id}/lisaavaihtoehdot", method = RequestMethod.GET)
	public String lisaaMonivalintaVaihtoehdot(@PathVariable("id") Long id, Model model) {
		Kysymys kysymys = kysymysrepo.findById(id).get();
		model.addAttribute("kysymys", kysymys);
		model.addAttribute("vaihtoehto", new MonivalintaVaihtoehto());
		return "asetavaihtoehdot";
	}

	// 7. Tallenna vaihtoehto monivalintakysymyksiin
	@RequestMapping(value = "/kysymys/{id}/tallennavaihtoehto", method = RequestMethod.POST)
	public String tallennaMonivalintaVaihtoehdot(@PathVariable("id") Long id,
			@ModelAttribute MonivalintaVaihtoehto monivalintavaihtoehto) {
		monivalintavaihtoehto.setMonivalintavaihtoehto(monivalintavaihtoehto.getMonivalintavaihtoehto());
		monivalintavaihtoehto.setKysymys(kysymysrepo.findById(id).get());
		monivalintarepo.save(monivalintavaihtoehto);
		return "redirect:/kysymys/{id}/lisaavaihtoehdot";
	}

	// 8. Poistaa vaihtoehdon id:n avulla
	@RequestMapping(value = "/kysymys/{id}/poista/{vaihtoehtoid}", method = RequestMethod.GET)
	public String poistaVaihtoehto(@PathVariable("id") Long id, @PathVariable("vaihtoehtoid") Long vaihtoehtoId) {
		monivalintarepo.delete(monivalintarepo.findById(vaihtoehtoId).get());
		return "redirect:/kysymys/{id}/lisaavaihtoehdot";
	}

}
