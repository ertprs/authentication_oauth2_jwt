package com.fmatheus.app.controller.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

    @Value("${api.secure.https}")
    private boolean SECURE_HTTPS;

    @Value("${api.context.path.token}")
    private String CONTEXT_PATH_TOKEN;

    @ApiOperation(value = "Logout")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Logout realizado"),
        @ApiResponse(code = 403, message = "Acesso Negado"),
        @ApiResponse(code = 500, message = "Erro no servidor"),})
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/revoke")
    public void revoke(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(SECURE_HTTPS);
        cookie.setPath(request.getContextPath() + CONTEXT_PATH_TOKEN);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

}
