package hello_big;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebMvcSecurity
@EnableWebSecurity
    public class WebSecurityConfigBig extends WebSecurityConfigurerAdapter{

    @Value("${user1.login")
    String user1Login;

    @Value("${user1.password}")
    String user1Pass;

    @Value("${user2.password}")
    String user2Pass;

    @Value("${user3.password}")
    String user3Pass;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/view-shop").permitAll()
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

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(user1Login);
        System.out.println(user1Pass);
        auth
                .inMemoryAuthentication()
//                .withUser("001").password("b").roles("USER")
                .withUser("001").password(user1Pass).roles("USER")
                .and()
//                .withUser("002").password("a").roles("USER")
                .withUser("002").password(user2Pass).roles("USER")
                .and()
//                .withUser("003").password("a").roles("USER");
                .withUser("003").password(user3Pass).roles("USER");



    }
}
