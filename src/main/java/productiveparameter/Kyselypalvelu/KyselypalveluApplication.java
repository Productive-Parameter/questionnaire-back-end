package productiveparameter.Kyselypalvelu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import productiveparameter.Kyselypalvelu.domain.KyselyRepo;
import productiveparameter.Kyselypalvelu.domain.KysymysRepo;
import productiveparameter.Kyselypalvelu.web.UserDetailServiceImpl;

@SpringBootApplication
public class KyselypalveluApplication {
	
	// private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KyselyRepo kyselyRepo, KysymysRepo kysymysRepo) {
		return  (args) -> {	
		};
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(new
	 BCryptPasswordEncoder());
	}

}
