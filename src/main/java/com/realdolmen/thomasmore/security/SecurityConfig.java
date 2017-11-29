package com.realdolmen.thomasmore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.realdolmen.thomasmore")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DriverManagerDataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)

        ;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/css/**").permitAll().antMatchers("/js/**").permitAll().antMatchers("/images/**").permitAll().antMatchers("/fonts/**").permitAll().antMatchers("/font/**").permitAll()
                .antMatchers("/login.xhtml").permitAll()
                .antMatchers("/index.xhtml").permitAll()
                .antMatchers("/userregistration.xhtml").permitAll()
                .antMatchers("/userupdate.xhtml").permitAll()
                .antMatchers("/createOrUpdateUser").permitAll()
                .antMatchers("/useroverview.xhtml").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin()
//                .loginPage("/login.xhtml")
                .defaultSuccessUrl("/index.xhtml")

//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/index.xhtml")
//                .permitAll()

//                .httpBasic()
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/fonts/**")
                .antMatchers("/public/**")
                .antMatchers("/javax.faces.resource/**")
//                .antMatchers("/**")
        ;
    }
}
