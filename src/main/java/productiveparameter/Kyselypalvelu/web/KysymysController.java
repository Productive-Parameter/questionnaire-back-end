package productiveparameter.Kyselypalvelu.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import productiveparameter.Kyselypalvelu.domain.Kysely;
import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;


@CrossOrigin(origins = "*")
@Controller
public class KysymysController {
	
	@Autowired private KyselyRepo kyselyrepo; 
	
	@Autowired private KysymysRepo kysymysrepo; 
	
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
    
     // 4.  Uuden kysymyksen lisääminen 
    @RequestMapping(value = "/kysymys/lisaa")
    public String lisaaKysymys(Model model){
    	model.addAttribute("kysymys", new Kysymys());
    	model.addAttribute("kyselyt", kyselyrepo.findAll());
    	return "lisaakysymys";
    }
    
     
     // 5. Tallenna kysymys
    @RequestMapping(value = "/kysymys/tallenna", method = RequestMethod.POST)
    public String tallennaKysymys(Kysymys kysymys){        
    	kysymysrepo.save(kysymys);
    	return "redirect:lisaakysymys";
    } 
    
}
