package com.cyber.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //steps for custom security configuration:
    //1. extend WebSecurityConfigurerAdapter class
    //2. override configure(HttpSecurity http) [for form structure] &
    //            -- we deal with authorization [antMatchers() identifies who will access what]
    //            configure(AuthenticationManagerBuilder auth) [for authentication]
    //            -- we describe roles in this method - ADMIN - MANAGER - USER
    //3. add @Configuration & @EnableWebSecurity annotations
    //4. create PasswordEncoder bean to encode passwords

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //every request should be authorized
                .antMatchers("index.html").permitAll() //give access to everyone
                .antMatchers("/profile/**").authenticated() //any role [admin, manager, user] can access profile folder
                .antMatchers("/admin/**").hasRole("ADMIN") //only admin can access admin folder
                .antMatchers("/management/**").hasAnyRole("ADMIN","MANAGER") //admin and manager can access management folder
                .and()
                .httpBasic(); //perform basic http authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("manager").password(passwordEncoder().encode("manager123")).roles("MANAGER")
                .and()
                .withUser("dennis").password(passwordEncoder().encode("dennis123")).roles("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
