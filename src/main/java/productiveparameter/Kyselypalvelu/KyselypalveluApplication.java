package productiveparameter.Kyselypalvelu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class KyselypalveluApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("https://kyselypalvelu.herokuapp.com/api/kyselies").allowedOrigins(
						"https://kyselypalvelu-ppfront.herokuapp.com");
				registry.addMapping("https://kyselypalvelu.herokuapp.com/api/kyselies").allowedOrigins(
						"https://kyselypalvelu-ppfront.herokuapp.com/kyselyt");
			}
		};
	}

}
