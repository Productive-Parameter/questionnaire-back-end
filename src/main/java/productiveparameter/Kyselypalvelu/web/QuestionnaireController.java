package productiveparameter.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import productiveparameter.Kyselypalvelu.domain.Question;
import productiveparameter.Kyselypalvelu.domain.QuestionRepository;
import productiveparameter.Kyselypalvelu.domain.Questionnaire;
import productiveparameter.Kyselypalvelu.domain.QuestionnaireRepository;

@Controller
public class QuestionnaireController {
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	
	@GetMapping("/questionnairelist")
	public String questionnaireList(Model model) {
		model.addAttribute("questionnaire", new Questionnaire());
		model.addAttribute("questionnaires", questionnaireRepository.findAll());
		return "questionnairelist"; // questionnairelist.html
	}
	
	@PostMapping("/savequestionnaire")
	public String saveQuestionnaire(Questionnaire questionnaire) {
		questionnaireRepository.save(questionnaire);
		return "redirect:questionnairelist"; // questionnairelist.html
	}
	
	@GetMapping("/editquestionnaire/{id}")
	public String editQuestionnaire(@PathVariable("id") Long questionnaireId, Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("questions", questionRepository.findAll());
		model.addAttribute("questionnaire", questionnaireRepository.findById(questionnaireId));
		return "editquestionnaire"; // editquestionnaire.html
	}
	
	

}
