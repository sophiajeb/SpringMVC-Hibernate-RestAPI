package com.mycompany.theatricalplays.model;

import org.springframework.beans.factory.annotation.Value;
// Krataei ta credentials apo to application-properties se ena model
public class OAuthProperties {
    @Value("${oauth.clientId}")
    private String clientId;
    @Value("${oauth.clientSecret}")
    private String clientSecret;
    @Value("${oauth.checkTokenUrl}")
    private String checkTokenUrl;
    @Value("${oauth.userInfoUrl}")
    private String userInfoUrl;
    @Value("${oauth.userEmailUrl}")
    private String userEmailUrl;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getCheckTokenUrl() {
        return checkTokenUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }
    
    public String getUserEmailUrl() {
        return userEmailUrl;
    }

    public void setUserEmailUrl(String userEmailUrl) {
        this.userEmailUrl = userEmailUrl;
    }

    @Override
    public String toString() {
        return "OAuthProperties{" + "clientId=" + clientId + ", clientSecret=" + clientSecret + ", checkTokenUrl=" + checkTokenUrl + ", userInfoUrl=" + userInfoUrl + ", userEmailUrl=" + userEmailUrl + '}';
    }
}
