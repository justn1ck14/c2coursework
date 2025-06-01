package com.coursework.cs2coursework.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/me")
    public String getUserInfo(@AuthenticationPrincipal OidcUser user) {
        return "Logged in as: " + user.getFullName();
    }

    @GetMapping("/roles")
    public String getUserRoles(JwtAuthenticationToken jwtToken) {
        return "User roles: " + jwtToken.getAuthorities();
    }
}