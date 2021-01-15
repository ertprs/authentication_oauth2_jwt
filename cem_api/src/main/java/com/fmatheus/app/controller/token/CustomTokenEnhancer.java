package com.fmatheus.app.controller.token;

import com.fmatheus.app.controller.security.UserSecury;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Value("${api.domain}")
    private String DOMAIN;

    @Value("${api.context.path}")
    private String CONTEXT_PATH;

    @Value("${api.path.avatar}")
    private String PATH_AVATAR;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        UserSecury user = (UserSecury) authentication.getPrincipal();

        Map<String, Object> info = new HashMap<>();
        info.put("id", user.getUser().getIdEmployee().getIdCreatedUser().getId());
        info.put("name", user.getUser().getIdEmployee().getIdPerson().getName());
        info.put("username", user.getUsername());
        info.put("image", DOMAIN + CONTEXT_PATH + PATH_AVATAR + user.getUser().getAvatar());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }

}
