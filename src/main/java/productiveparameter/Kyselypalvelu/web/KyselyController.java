package productiveparameter.Kyselypalvelu.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import productiveparameter.Kyselypalvelu.domain.Kysely;
import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;




@Controller
public class KyselyController {

	@Autowired private KyselyRepo kyselyrepo; 
	@Autowired private KysymysRepo kysymysRepo;
	
	/*********** RESTFUL SERVICES ************************/
	
	// REST kaikkien teemojen hakuun
	@RequestMapping(value="/api/kyselyt", method = RequestMethod.GET)
	public @ResponseBody List<Kysely> kyselyListaRest() {	
		return (List<Kysely>) kyselyrepo.findAll();
	}    

	// REST hakee kyselyn id:n perusteella  <td><a th:href="@{theme/{id}(id=${theme.themeid})}"
	@RequestMapping(value="/api/kyselyt/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long id) {	
		return kyselyrepo.findById(id);
	}
	
	/*****************************************************/

	// 1.  hakee kaikki kyselyt ja mahdollistaa uuden kyselyn luomisen

	@RequestMapping(value="/kyselyt")
	public String kyselyLista(Model model) {	
		model.addAttribute("kyselyt", kyselyrepo.findAll());
		model.addAttribute("uusiKysely", new Kysely());
		return "kyselyt";
	}

	// 2.  uuden kyselyn lisääminen (tyhjä lomake) --vanha--

	@RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
	public String getUusiLomake(Model model) {
		List<Kysymys> kysymykset = new ArrayList<Kysymys>();
		model.addAttribute("kysely", new Kysely("", kysymykset));
		model.addAttribute("kysymys", new Kysymys()); // "tyhjä" olio
		return "uusikysely";
	}

	// 3. kyselyn tallennus  

	@RequestMapping(value = "/kyselyt/tallenna", method = RequestMethod.POST)
	public String tallenna(Kysely kysely){
		kyselyrepo.save(kysely);
		return "redirect:/kyselyt";        
	}    
    
	// 4. Kyselyä klikkaamalla näyttää kyselyn kysymykset kyselyn sivulla (hakee kysymykset kyselyn id:n perusteella)

	@RequestMapping(value = "/kyselyt/{id}", method =RequestMethod.GET)
	public String haeKysely(@PathVariable("id") Long id, Model model){
		Kysely kysely = kyselyrepo.findById(id).get(); 	
		model.addAttribute("kysely", kysely);
		model.addAttribute("kysymys", new Kysymys());
		return "kysely";
	}
	
	// 5. Tallentaa uuden kysymyksen kyselyyn 
	@RequestMapping(value = "/kyselyt/{id}/lisaa", method = RequestMethod.POST)
	public String lisaaKysymys(@PathVariable("id") Long id, @ModelAttribute Kysymys kysymys) {
		kysymys.setTeksti(kysymys.getTeksti());
		kysymys.setTyyppi(kysymys.getTyyppi());
		kysymys.setKysely(kyselyrepo.findById(id).get());
		kysymysRepo.save(kysymys);
		return "redirect:/kyselyt/{id}";
	}
	
	// 6. Poistaa kysymyksen id:n avulla
	@RequestMapping(value = "kyselyt/{id}/poista/{kysymysid}", method = RequestMethod.GET)
	public String poistaKysymys(@PathVariable("id") Long id, @PathVariable("kysymysid") Long kysymysId) {
		kysymysRepo.delete(kysymysRepo.findById(kysymysId).get());
		return "redirect:/kyselyt/{id}";
	}
     
     
	// ??   näyttää kaikki kysymykset kyselysivulla http://localhost:8080/kysely
	@RequestMapping(value="/kyselyt/kysymykset")
	public String kysymysLista(Model model) {	
		List<Kysymys> kysymykset = (List<Kysymys>) kysymysRepo.findAll();	
		model.addAttribute("kysymykset", kysymykset);	
		return "kysely";
	}
}