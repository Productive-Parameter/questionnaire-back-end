package productiveparameter.Kyselypalvelu.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> da31b29f7a9a34f31f7669e8fd8fbbfa01adec9a
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import productiveparameter.Kyselypalvelu.domain.Kysely;
import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;
import productiveparameter.Kyselypalvelu.domain.MonivalintaVaihtoehdot;
import productiveparameter.Kyselypalvelu.domain.MonivalintaVaihtoehdotRepo;


@CrossOrigin(origins = "*")
@Controller
public class KysymysController {
	
	@Autowired private KyselyRepo kyselyrepo; 
	
	@Autowired private KysymysRepo kysymysrepo; 
	
	@Autowired private MonivalintaVaihtoehdotRepo monivalintarepo;
	
    /************ RESTFUL SERVICES ***************/
	// 2.  REST --> hakee kaikki kysymykset osoitteeseen http://localhost:8080/words
    @RequestMapping(value="/api/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymyslistaRest() {	
    	return (List<Kysymys>) kysymysrepo.findAll();
    }
    
	// 3. REST --> hakee kysymyksiä id:n avulla
    @RequestMapping(value="/api/kysymykset/{id}", method = RequestMethod.GET)
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
    
     // 4.  Uuden kysymyksen lisääminen HUOM!!!!!!!!!!! Ei käytetä tällä hetkellä 
    @RequestMapping(value = "/kysymys/lisaa")
    public String lisaaKysymys(Model model){
    	model.addAttribute("kysymys", new Kysymys());
    	model.addAttribute("kyselyt", kyselyrepo.findAll());
    	return "lisaakysymys";
    }
    
     
     // 5. Tallenna kysymys HUOM!!!!!!!!!!! Ei käytetä tällä hetkellä
    @RequestMapping(value = "/kysymys/tallenna", method = RequestMethod.POST)
    public String tallennaKysymys(Kysymys kysymys){        
    	kysymysrepo.save(kysymys);
    	return "redirect:lisaakysymys";
    } 
    
    // 6. Lisää vaihtoehdot monivalintakysymyksiin
    @RequestMapping(value = "/kysymys/{id}/lisaavaihtoehdot", method = RequestMethod.GET)
    public String lisaaMonivalintaVaihtoehdot(@PathVariable("id") Long id, Model model) {
    	Kysymys kysymys = kysymysrepo.findById(id).get();
    	model.addAttribute("kysymys", kysymys);
    	model.addAttribute("vaihtoehdot", new MonivalintaVaihtoehdot());
    	return "asetavaihtoehdot";
    }
    
    // 7. Tallenna vaihtoehdot monivalintakysymyksiin
    @RequestMapping(value = "/kysymys/{id}/tallennavaihtoehdot", method = RequestMethod.POST)
    public String tallennaMonivalintaVaihtoehdot(@PathVariable("id") Long id, @ModelAttribute MonivalintaVaihtoehdot vaihtoehdot, RedirectAttributes redirectAttribbutes) {
    	vaihtoehdot.setVaihtoehto1(vaihtoehdot.getVaihtoehto1());
    	vaihtoehdot.setVaihtoehto2(vaihtoehdot.getVaihtoehto2());
    	vaihtoehdot.setVaihtoehto3(vaihtoehdot.getVaihtoehto3());
    	vaihtoehdot.setVaihtoehto4(vaihtoehdot.getVaihtoehto4());
    	vaihtoehdot.setVaihtoehto5(vaihtoehdot.getVaihtoehto5());
    	Kysymys kysymys = kysymysrepo.findById(id).get();
    	vaihtoehdot.setKysymys(kysymys);
    	monivalintarepo.save(vaihtoehdot);
    	redirectAttribbutes.addAttribute("kyselyid", kysymys.getKysely().getId());
    
    	System.out.println(kysymys.getMonivalintavaihtoehdot());
    	return "redirect:/kyselyt/{kyselyid}";
    }
    
}
