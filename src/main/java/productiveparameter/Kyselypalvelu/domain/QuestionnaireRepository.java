package productiveparameter.Kyselypalvelu.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {
		List<Question> findByName(String name);

	}
