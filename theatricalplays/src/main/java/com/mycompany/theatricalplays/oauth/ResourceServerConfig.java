package com.mycompany.theatricalplays.oauth;

import com.mycompany.theatricalplays.model.OAuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

// Setarw ton tropo pou 8a ginei to security

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private OAuthProperties oAuthProperties;

    
    // energopoiw ton tropo pou 8a ginei to security (ti kleidwnw mesa sthn efarmogh kai pws) 
    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable();

        // for permitting all requests
        http.authorizeRequests().anyRequest().permitAll();
        
//        // public login form
//        http.authorizeRequests().antMatchers("/").permitAll();

//        // accept OPTIONS from all endPoints
//        String allEndPoints = "\"/api/users\", \"/api/user/**\", \"/api/play\", \"/api/play/*\", \"/api/play/*\", \"/api/plays\", \"/api/play/*\", \"/api/reservation\", \"/api/reservations\", \"/api/reservation/*\", \"/api/room\", \"/api/room/*\", \"/api/room/*\"";
//        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, allEndPoints).permitAll();

//        // /api/users only by ADMIN ROLE
//        http.authorizeRequests().antMatchers("/api/users", "/api/user/**").hasRole("ADMIN");
        
//        // POST, PUT, DELETE, /api/play/*, ADMIN
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/play").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/play/*").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/play/*").hasAnyRole("ADMIN");
        
//        // GET /api/plays, /api/play/*, USER
//        // change it to anonymous
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/plays", "/api/play/*").hasAnyRole("USER","ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/plays", "/api/play/*").anonymous();

//        // POST, PUT, DELETE /api/reservation/*, ADMIN, USER
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/reservation").hasAnyRole("ADMIN", "USER");
//        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/reservation/*").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/reservation/*").hasAnyRole("ADMIN");
        
//        // GET /api/reservations, /api/reservation/*, USER, ADMIN
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/reservations", "/api/reservation/*").hasAnyRole("USER", "ADMIN");
        
//        // POST, PUT, DELETE /api/room/*, ADMIN
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/room").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/room/*").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/room/*").hasAnyRole("ADMIN");
        
//        // GET /api/rooms, /api/room/*, ADMIN
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/rooms", "/api/room/*").hasAnyRole("ADMIN");

//        http.authorizeRequests().anyRequest().authenticated();
    }

    // dhlwnw tous tropous pou 8a milhsw me to Google API
    // kleidwnw ka8e resource ana client id kataxwrontas to sto resource id
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(oAuthProperties.getClientId());
    }

    
    @Bean
    public ResourceServerTokenServices tokenServices(OAuthProperties oAuthProperties, AccessTokenValidator tokenValidator) {
        GoogleTokenServices googleTokenServices = new GoogleTokenServices(tokenValidator);
        googleTokenServices.setUserInfoUrl(oAuthProperties.getUserInfoUrl());
        //googleTokenServices.setUserEmailUrl(oAuthProperties.getUserEmailUrl());
        return googleTokenServices;
    }

    
    //kanw validate ka8e request pou periexei token kai zhtaei access
    @Bean
    public AccessTokenValidator tokenValidator(OAuthProperties oAuthProperties) {
        GoogleAccessTokenValidator accessTokenValidator = new GoogleAccessTokenValidator();
        accessTokenValidator.setClientId(oAuthProperties.getClientId());
        accessTokenValidator.setCheckTokenUrl(oAuthProperties.getCheckTokenUrl());
        return accessTokenValidator;
    }
}
