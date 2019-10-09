package com.amaduse.workflow_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) throws Exception {//配置，不用验证登录的api
        web.ignoring()
                    .antMatchers("/v2/api-docs/**")
                    .antMatchers("/swagger.json")
                    .antMatchers("/swagger-ui.html")
                    .antMatchers("/resources/")
                    .antMatchers("/swagger-resources/**")
                    .antMatchers("/webjars/**")
                    .antMatchers("/process/**")
                    .antMatchers("/task/**")
                    .antMatchers("/flow/**");
    }

    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        this.configure(http);
    }
}
