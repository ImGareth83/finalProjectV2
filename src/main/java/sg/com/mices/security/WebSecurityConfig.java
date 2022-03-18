package sg.com.mices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public WebSecurityConfig(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configAuthentication");

        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

    @CrossOrigin
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure");
        http.csrf().disable();

        //Not using the Spring Security HttpSecurity default login page
        http.formLogin().loginPage("/login");

        //if user successfully login, user will be directed to the productform.html
        http.formLogin()
                .defaultSuccessUrl("/files/form");

        //if user successfully logout, user will be directed to the index.html
        http.logout()
                .logoutSuccessUrl("/index");


        /*.antMatchers(......).permitAll() - tells Spring Security that these webpages
         do not need to have login services

        .antMatchers(.....).hasRole("ADMIN") - tells Spring Security that only user
        with ADMIN role will be able to access the productform.html

        logout method : configure logout functionality provided by Spring Security -
        ensure that the login session to be invalidated.

         */
        http.authorizeRequests()
                .antMatchers("/", "/product", "/abtus").permitAll()
                .antMatchers("/form/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }


}
