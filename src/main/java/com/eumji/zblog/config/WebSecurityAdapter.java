package com.eumji.zblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * FILE: com.eumji.zblog.config.WebSecurityAdapter.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 9:33
 */
@Configuration
@EnableWebSecurity
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/blog/**","/tag/**","friend","/login/**").permitAll()
                .antMatchers("/admin/**").authenticated()
                .and().formLogin().loginPage("/loginPage").permitAll()
                .and().logout().permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin/**","/js/**","/css/**","/vendor/**","/iamge/**");
    }

}
