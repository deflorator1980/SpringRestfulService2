package my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Value("${user1.login}")
    String user1Login;

    @Value("${user2.login}")
    String user2Login;

    @Value("${user3.login}")
    String user3Login;

    @Value("${user1.password}")
    String user1Pass;

    @Value("${user2.password}")
    String user2Pass;

    @Value("${user3.password}")
    String user3Pass;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/gnomes", "/", "/view-shop").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(user1Login).password(user1Pass).roles("USER")
                .and()
                .withUser(user2Login).password(user2Pass).roles("USER")
                .and()
                .withUser(user3Login).password(user3Pass).roles("USER");


    }

}
