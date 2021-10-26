package productiveparameter.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import productiveparameter.Kyselypalvelu.domain.Question;
import productiveparameter.Kyselypalvelu.domain.QuestionRepository;

@Controller
public class KyselypalveluController {
	
	@Autowired
	private QuestionRepository qrepository;
	
	@RequestMapping(value= {"/addquestions", "/"})
	public String welcome(Model model) {
		
		return "addquestions";
	}
		
	@RequestMapping(value = {"/savequestion"}, method = RequestMethod.POST)
	public String addQuestion(Model model, Question question) {
		qrepository.save(question);
		return "addquestions";
	}
}

