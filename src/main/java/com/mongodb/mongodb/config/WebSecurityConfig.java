package com.mongodb.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



    @Configuration //init spring configuration
    @EnableWebSecurity //tolong aktifkan security
    @EnableGlobalMethodSecurity(prePostEnabled = true) //menjalankan semua

    //mengoveride websecurtyconfigadapter
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    // starts authorizing configurations
                    .authorizeRequests()
                    // authenticate all remaining URLS
                    .anyRequest().permitAll().and()
                    // adding JWT filter
                    .addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                    // enabling the basic authentication
                    .httpBasic().and()
                    // configuring the session as state less. Which means there is
                    // no session in the server
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS.STATELESS).and()
                    // disabling the CSRF - Cross Site Request Forgery
                    .cors()
                    .and()
                    .csrf().disable();
        }

        //tempat mengatur siapa yang di bolehin
        @Override
        public void configure(WebSecurity web) throws Exception {
            // TokenAuthenticationFilter will ignore the below paths
            web.ignoring().antMatchers(HttpMethod.POST, "/user/**");
        }
    }


