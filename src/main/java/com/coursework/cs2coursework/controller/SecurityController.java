package com.coursework.cs2coursework.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
@Tag(name = "Security", description = "API для авторизації та ролей")
@SecurityRequirement(name = "oauth2")
public class SecurityController {

    @GetMapping("/me")
    @Operation(summary = "Отримати дані користувача", description = "Потребує `Bearer Token`")
    @SecurityRequirement(name = "oauth2")
    public ResponseEntity<UserResponse> getUserInfo(Authentication authentication) {
        UserResponse userResponse = new UserResponse(authentication.getName(), "cs2market@example.com");
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/roles")
    @Operation(summary = "Отримати ролі користувача", description = "Потребує `Bearer Token`")
    @SecurityRequirement(name = "oauth2")
    public ResponseEntity<String[]> getUserRoles(Authentication authentication) {
        String[] roles = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .toArray(String[]::new);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/update")
    @Operation(summary = "Оновити дані користувача", description = "Потребує `Bearer Token`")
    @SecurityRequirement(name = "oauth2")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateRequest request, Authentication authentication) {
        UserResponse updatedUser = new UserResponse(authentication.getName(), request.getEmail());
        return ResponseEntity.ok(updatedUser);
    }

    public static class UserResponse {
        private String username;
        private String email;

        public UserResponse(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }
    }

    public static class UpdateRequest {
        private String email;

        public String getEmail() {
            return email;
        }
    }
}