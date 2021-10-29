package productiveparameter.Kyselypalvelu_ilmanRESTia.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import productiveparameter.Kyselypalvelu_ilmanRESTia.domain.Kysely;
import productiveparameter.Kyselypalvelu_ilmanRESTia.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu_ilmanRESTia.domain.KysymysRepo;




@Controller
public class KyselyController {

	@Autowired	
	private KyselyRepo repository; 
	
	@Autowired	
	private KysymysRepo wrepository; 
	
	
	
	// näyttää kaikki kyselyt
    @RequestMapping(value="/kyselyt")
    public String kyselyLista(Model model) {	
        model.addAttribute("kyselyt", repository.findAll());
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
        repository.save(kysely);
        return "redirect:kyselyt";        
    }    

	}