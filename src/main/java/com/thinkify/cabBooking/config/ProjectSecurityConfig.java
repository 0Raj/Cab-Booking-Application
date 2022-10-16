package com.thinkify.cabBooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain cabBookingSecurity(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth ->
                {
                    try {
                        auth.antMatchers("/user","/driver").permitAll()
                                .antMatchers("/car").authenticated()
                                .antMatchers("/search","/book").authenticated()
                                .antMatchers("/car").hasAnyRole("DRIVER")
                                .antMatchers("/search","/book").hasAnyRole("CUSTOMER")
                                .and().csrf().disable().formLogin().loginProcessingUrl("/login")
                                .and().logout().logoutUrl("/logout");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
