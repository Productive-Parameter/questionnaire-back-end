package productiveparameter.Kyselypalvelu.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import productiveparameter.Kyselypalvelu.domain.Question;
import productiveparameter.Kyselypalvelu.domain.QuestionRepository;
import productiveparameter.Kyselypalvelu.domain.Questionnaire;

@Controller
public class KyselypalveluController {
	
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private QuestionRepository qurepository;
	
	
	@RequestMapping(value= {"/addquestions", "/"})
	public String addquestion(Model model) {
		return "addquestions";
	}
		
	// vastaanottaa kysmykyset thymleafilta
	@RequestMapping(value = {"/savequestion"}, method = RequestMethod.POST)
	public String addQuestion(Model model, Question question) {
		List<Question> lista = new ArrayList<>();
		model.addAttribute(question);
		qrepository.save(question);
		return "addquestions";
	}
	// 
	@RequestMapping(value= {"/addquestionnaire"})
	public String addquestionnaire(Model model) {
		return "addquestionnaire";
	}
	@RequestMapping(value= "/savequestionnaire", method = RequestMethod.POST)
	public String saveQuestionnaire(Model model, Questionnaire questionnaire) {
		System.out.println("MODEL: "+model +"Questionnaire " + questionnaire);
		model.addAttribute(new Questionnaire(""));
		System.out.println(questionnaire);
		return "addquestionnaire";
	}
	
	
}

