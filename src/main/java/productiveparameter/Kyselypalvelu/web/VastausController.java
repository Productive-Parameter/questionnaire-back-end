package productiveparameter.Kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;
import productiveparameter.Kyselypalvelu.domain.Vastaus;
import productiveparameter.Kyselypalvelu.domain.VastausRepo;

@Controller
@CrossOrigin(origins = "*")
public class VastausController {
	
	@Autowired private VastausRepo repository;
	
	/**************** RESTFUL SERVICES ***********************/
	
	@RequestMapping(value = "/api/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> listVastauksetRest() {
		return (List<Vastaus>) repository.findAll();
	}
	
	@RequestMapping(value = "/api/vastaukset/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Vastaus> vastausRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@RequestMapping(value = "/api/vastaukset", method = RequestMethod.POST)
	public @ResponseBody Vastaus saveRest(@RequestBody Vastaus vastaus, @RequestBody Kysymys kysymys) {
		Vastaus newVastaus = new Vastaus(vastaus.getVastaus(), kysymys);
		repository.save(newVastaus);
		return vastaus;
	}
	
	/*********************************************************/
	
	@RequestMapping(value = "/vastaukset", method = RequestMethod.GET)
	public String listVastaukset(Model model) {
		List<Vastaus> vastaukset = (List<Vastaus>) repository.findAll();
		model.addAttribute("vastaukset", vastaukset);
		// lisää thymeleaf template
		return "";
	}
	
	@RequestMapping(value = "/vastaukset/{id}", method = RequestMethod.GET) 
		public String vastaus(@PathVariable("id") Long id, Model model) {
			model.addAttribute(repository.findById(id));
			// lisää thymeleaf template
			return "";
		}
}
