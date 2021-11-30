package productiveparameter.Kyselypalvelu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;

@SpringBootApplication
public class KyselypalveluApplication {
	
	// private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepo kyselyRepo, KysymysRepo kysymysRepo) {
		return  (args) -> {	
		};
	}

}
