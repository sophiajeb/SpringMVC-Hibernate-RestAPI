package com.mycompany.theatricalplays.oauth;

import com.mycompany.theatricalplays.model.User;
import com.mycompany.theatricalplays.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import java.math.BigInteger;
import java.util.Map;
import static java.util.Collections.singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleTokenServices implements ResourceServerTokenServices, InitializingBean {
    @Autowired
    private UserService userService;
    private String userInfoUrl;
    private String userEmailUrl;

    private RestTemplate restTemplate = new RestTemplate();
    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
    private AccessTokenValidator tokenValidator;

    public GoogleTokenServices(AccessTokenValidator tokenValidator) {
        this.tokenValidator = tokenValidator;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(userInfoUrl, "userInfoUrl must not be blank");
    }

    // tsekarei an ena token einai valid 
    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        AccessTokenValidationResult validationResult = tokenValidator.validate(accessToken);
        if (!validationResult.isValid()) {
            throw new UnapprovedClientAuthenticationException("The token is not intended to be used for this application.");
        }
        Map<String, ?> tokenInfo = validationResult.getTokenInfo();
        OAuth2Authentication authentication = getAuthentication(tokenInfo, accessToken);
        return authentication;
    }

    private OAuth2Authentication getAuthentication(Map<String, ?> tokenInfo, String accessToken) {
        OAuth2Request request = tokenConverter.extractAuthentication(tokenInfo).getOAuth2Request();
        Authentication authentication = getAuthenticationToken(accessToken);
//        authentication.setAuthenticated(true);
        return new OAuth2Authentication(request, authentication);
    }

    private Authentication getAuthenticationToken(String accessToken) {
        Map<String, ?> userInfo = getUserInfo(accessToken);
        System.out.println("userInfo:" + userInfo);
        JSONObject obj = new JSONObject(userInfo);
//        System.out.println("google_id:" + obj.getJSONArray("names").getJSONObject(0).getJSONObject("metadata").getJSONObject("source").getString("id"));
        String familyName = obj.getJSONArray("names").getJSONObject(0).getString("familyName");
        String givenName = obj.getJSONArray("names").getJSONObject(0).getString("givenName");
        String idStr = obj.getJSONArray("names").getJSONObject(0).getJSONObject("metadata").getJSONObject("source").getString("id");
        User user = new User();
        user.setLast_name(familyName);
        user.setFirst_name(givenName);
        user.setGoogleId(idStr);
        
//        Map<String, ?> emailInfo = getEmailInfo(accessToken, idStr);
//        String email = emailInfo.get("emailAddress").toString();
        user.setEmail("fake@email.com");
        
        if (idStr == null) {
            throw new InternalAuthenticationServiceException("Cannot get id from user info");
        }
        // introduce the two roles, USER, ADMIN
        // prepei na koitaksw sth bash gia to sygkekrimeno xrhsth ti rolo exei
        
        // mono gia tous "superadmin" dinetai apeutheias access me GoogleId:34324234,234234324
        // GET with OAuth2 and access token the user details with URL: https://people.googleapis.com/v1/people/me?personFields=names,emailAddresses
        // sophiajeb93@gmail.com id: ...
        // stavros ... id: ....
//        return new UsernamePasswordAuthenticationToken(new GooglePrincipal(new BigInteger(idStr)), null, singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        if(idStr.equals("106093846062790960618") || idStr.equals("000000") || idStr.equals("00000")) {
            return new UsernamePasswordAuthenticationToken(new GooglePrincipal(new BigInteger(idStr)), null, singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }
        else {
            // create some code that checks on the database for each user with this idStr (GoogleId) what role he has and differentiate between
            if(!userService.isAdmin(idStr)) {
                user.setMobile_phone("1111111111");
                user.setUsername(familyName + givenName.substring(0, 0));
                user.setPassword(familyName + givenName.substring(0, 0));
                System.out.println("user data=" + user);
                userService.saveUser(user);
                return new UsernamePasswordAuthenticationToken(new GooglePrincipal(new BigInteger(idStr)), null, singleton(new SimpleGrantedAuthority("ROLE_USER")));
            } 
            else {
                // this is given to people that have the role ADMIN on Users table
                user.setRole("ADMIN");
                System.out.println("user data=" + user);
                userService.updateUser(user);
                return new UsernamePasswordAuthenticationToken(new GooglePrincipal(new BigInteger(idStr)), null, singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
            }
        }
    }

    private Map<String, ?> getUserInfo(String accessToken) {
        HttpHeaders headers = getHttpHeaders(accessToken);
        Map map = restTemplate.exchange(userInfoUrl, HttpMethod.GET, new HttpEntity<>(headers), Map.class).getBody();
        return (Map<String, Object>) map;
    }
    
    private Map<String, ?> getEmailInfo(String accessToken, String id) {
        //https://www.googleapis.com/gmail/v1/users/userId/profile
        String url = userEmailUrl + id + "/profile";
        System.out.println("url:" + url);
        HttpHeaders headers = getHttpHeaders(accessToken);
        Map map = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Map.class).getBody();
        return (Map<String, Object>) map;
    }
    

    private HttpHeaders getHttpHeaders(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        return headers;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getUserEmailUrl() {
        return userEmailUrl;
    }

    public void setUserEmailUrl(String userEmailUrl) {
        this.userEmailUrl = userEmailUrl;
    }
}
