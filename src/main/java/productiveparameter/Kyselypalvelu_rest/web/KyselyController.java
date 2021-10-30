package productiveparameter.Kyselypalvelu_rest.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import productiveparameter.Kyselypalvelu_rest.domain.Kysely;
import productiveparameter.Kyselypalvelu_rest.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu_rest.domain.KysymysRepo;




@Controller
public class KyselyController {

	@Autowired	
	private KyselyRepo kyselyrepo; 
	
	@Autowired	
	private KysymysRepo kysymysrepo; 
	
	
	
	// näyttää kaikki kyselyt
    @RequestMapping(value="/kyselyt")
    public String kyselyLista(Model model) {	
        model.addAttribute("kyselyt", kyselyrepo.findAll());
        return "kyselyt";
    }
    


	// tyhjän lomakkeen muodostaminen
	@RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
	public String getUusiLomake(Model model) {
		model.addAttribute("kysely", new Kysely()); // "tyhjä" olio
		return "uusikysely";
	}


	  //Tallennus
    @RequestMapping(value = "/tallenna", method = RequestMethod.POST)
    public String save(Kysely kysely){
        kyselyrepo.save(kysely);
        return "redirect:kyselyt";        
    }    

	}