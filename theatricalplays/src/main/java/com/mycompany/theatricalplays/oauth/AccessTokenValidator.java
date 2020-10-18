package com.mycompany.theatricalplays.oauth;

public interface AccessTokenValidator {
    AccessTokenValidationResult validate(String accessToken);
}
