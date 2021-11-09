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
				kyselyRepo.save(kysely1);

				
				kysymysRepo.save(new Kysymys("Minkä ikäinen olet?", "teksti", true , kysely1));				
				kysymysRepo.save(new Kysymys("Sukupuoli?", "radio", true, kysely1));
				kysymysRepo.save(new Kysymys("Miten etäopiskelu on vaikuttanut opiskelumotivaatioon?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Miten etäopiskelu on vaikuttanut opiskelun laatuun?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Kauan olet etäopiskellut yhteensä?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Kauan olet lähiopiskellut yhteensä?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Miten etäopiskelu on vaikuttanut toimintasi aikataulutukseen?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Pidätkö enemmän lähi- vai etäopiskelusta?", "radio", true, kysely1));
				kysymysRepo.save(new Kysymys("Mitkä ovat mielestäsi etäopiskelun hyviä puolia?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Entä etäopiskelun huonot puolet?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Mitkä ovat mielestäsi lähiopiskelun hyviä puolia?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Entä lähiopiskelun huonot puolet?", "teksti", true, kysely1));
				kysymysRepo.save(new Kysymys("Käytkö etäopiskelun aikana ruokailemassa koululla, kun on mahdollista?", "radio", true, kysely1));
				kysymysRepo.save(new Kysymys("Kuinka monta kertaa käyt ruokailemassa koululla?", "skaala", true, kysely1));
				kysymysRepo.save(new Kysymys("Koetko opiskeluvälineet paremmiksi etänä tai koululla?", "radio", true, kysely1));
				kysymysRepo.save(new Kysymys("Ovatko tenttijärjestelyt mielestäsi toteutuneet hyvin etäopiskelun aikana?", "check", true, kysely1));
				kysymysRepo.save(new Kysymys("Sujuvatko ryhmätyöt mielestäsi paremmin etänä vai koululla?", "check", true, kysely1));
				kysymysRepo.save(new Kysymys("Muita mielipiteitä liittyen etä- ja lähiopiskeluun?", "teksti", false, kysely1));
				kysymysRepo.save(new Kysymys("Kuinka tyytyväinen olet tähän kyselyyn?", "skaala", false, kysely1));
				
		};
	}

}
