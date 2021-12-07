package productiveparameter.Kyselypalvelu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    // @Autowired
    // private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests().antMatchers("/css/**").permitAll() // Css käytössä vaikkei olisi kirjautuneena sisään
            .and()
            .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll() // Katsotaan tarvitaanko tätä tai tuleeko tähän jotain lisää tai muuta tilalle
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/", true).permitAll()
            .and()
        .logout()
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
