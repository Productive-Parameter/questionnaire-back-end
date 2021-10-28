package productiveparameter.Kyselypalvelu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import productiveparameter.Kyselypalvelu.domain.Question;
import productiveparameter.Kyselypalvelu.domain.QuestionRepository;
import productiveparameter.Kyselypalvelu.domain.Questionnaire;

@SpringBootApplication
public class KyselypalveluApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner questionDemo(QuestionRepository qrepository) {
		return args->{
			qrepository.save(new Question("Mitä kuuluu"));
			qrepository.save(new Question("Mitä Kuuluu???"));
		};
	}
}
