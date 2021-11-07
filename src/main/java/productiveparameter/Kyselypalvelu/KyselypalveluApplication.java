package productiveparameter.Kyselypalvelu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import productiveparameter.Kyselypalvelu.domain.Kysely;
import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.Kysymys;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;

@SpringBootApplication
public class KyselypalveluApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepo kyselyRepo, KysymysRepo kysymysRepo) {
		return  (args) -> {
				
				log.info("insert example data of kysely to database");
				
				List<Kysymys> kysymykset = new ArrayList<Kysymys>();
				Kysely kysely1 = new Kysely("Sopeutuminen etäopiskelusta lähiopiskeluun.", kysymykset);
				kysely1.getKysymykset().add(new Kysymys("Minkä ikäinen olet?", "teksti" , kysely1));
				kyselyRepo.save(kysely1);
		};
	}

}
