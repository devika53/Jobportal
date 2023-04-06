package com.job.broad.config;

import com.job.broad.filters.JWTAuthorizationFilter;
import com.job.broad.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.POST;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final UserDetailsService userDetailsService;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter customAuthenticationFilter = new JwtAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login/**");
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers(
                "/api/login/**",
                "/api/login",
                "/api/welcome",
                "/api/v1/addUser",
                "/api/role/**",
                "/api/role/addtouser/**",
                "/api/token/refresh/**",
                "/api/users/save/**",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/webjars/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/api/v1/addEmployer/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/api/v1/saveuser/**").permitAll();
        /*
          Listing all function having access to user with role ADMIN,APPLICANT,EMPLOYER
        */

        http.authorizeRequests().antMatchers(GET, "/api/users/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/role/save/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/role/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/api/role/update/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/role/delete/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/tags/save/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/tags/**")
                .hasAnyAuthority("ADMIN", "EMPLOYER", "APPLICANT");
        http.authorizeRequests().antMatchers(PUT, "/api/tags/update/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/tags/delete/**")
                .hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/jobs/**")
                .hasAnyAuthority("EMPLOYER", "ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/job/save/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(POST, "/api/job/create/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(PUT, "/api/job/update/{jobId}/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(POST, "/api/job/find/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(POST, "/api/job/addskills/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/applicant/**")
                .hasAnyAuthority("APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/skill/addtouser/**")
                .hasAnyAuthority("APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/job/apply/**")
                .hasAnyAuthority("APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/jobs/applied/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/users/**")
                .hasAnyAuthority("EMPLOYER", "APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/job/hire/{jobId}/{email}/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(POST, "/api/v1/addJob/**")
                .hasAnyAuthority("EMPLOYER");
        http.authorizeRequests().antMatchers(POST, "/api/v1/addSkills/**")
                .hasAnyAuthority("Admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("PUT", "DELETE", "POST", "GET");
            }
        };
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
