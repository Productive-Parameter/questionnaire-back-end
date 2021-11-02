package productiveparameter.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import productiveparameter.Kyselypalvelu.domain.Question;
import productiveparameter.Kyselypalvelu.domain.QuestionRepository;


@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	// TODO Kysymysten muokkaus ja poisto
	
	@PostMapping("/savequestion")
	public String saveQuestion(Question question) {
		questionRepository.save(question); // <--- ei näin, kytke kyselyrepoon
		return ""; // editquestionnaire.html <-- ja kyseisen kyselyn id
		// path variable-hommia
	}

}
