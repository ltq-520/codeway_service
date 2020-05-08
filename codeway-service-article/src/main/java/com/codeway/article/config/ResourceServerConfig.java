package com.codeway.article.config;

import com.codeway.article.handler.CustomAccessDeniedHandler;
import com.codeway.article.handler.CustomAuthenticationEntryPoint;
import com.codeway.utils.security.JWTAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "publickey.txt";

    @Override
    public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) {
        resourceServerSecurityConfigurer
                .tokenStore(tokenStore())
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .resourceId("service-article");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/management/**").hasAuthority("ROLE_ADMIN")
            .antMatchers("/swagger-resources/configuration/ui").permitAll()
            .antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources",
                "/configuration/security",
                "/webjars/**",
                "/swagger-resources/configuration/ui",
                "/swagger-ui.html",
                "/swagger-resources/configuration/security").permitAll()
                .antMatchers("/**").authenticated();
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(JWTAuthentication.getPubKey(PUBLIC_KEY));
        return converter;
    }
}
