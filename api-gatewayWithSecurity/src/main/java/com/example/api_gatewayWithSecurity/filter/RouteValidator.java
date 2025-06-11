package com.example.api_gatewayWithSecurity.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import com.example.api_gatewayWithSecurity.service.JwtService;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    @Autowired
    private JwtService jwtService;

    private static final List<String> OPEN_API_ENDPOINTS = List.of(
            "/security/register",
            "/security/authenticate",
            "/auth/**",
            "/eureka"
    );

    private static final List<String> FARMER_API_ENDPOINTS = List.of("/Farmer/**");
    private static final List<String> DEALER_API_ENDPOINTS = List.of("/dealer/**");

    public Predicate<ServerHttpRequest> isSecured =
            request -> OPEN_API_ENDPOINTS.stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

    public Predicate<ServerHttpRequest> isFarmerUri =
            request -> FARMER_API_ENDPOINTS.stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));

    public Predicate<ServerHttpRequest> isDealerUri =
            request -> DEALER_API_ENDPOINTS.stream()
                    .anyMatch(uri -> request.getURI().getPath().contains(uri));


    public boolean validateUserAccess(String token, ServerHttpRequest request) {
        try {
            String role = jwtService.extractRole(token);

            if ((isFarmerUri.test(request) && "ROLE_FARMER".equals(role)) ||
                (isDealerUri.test(request) && "ROLE_DEALER".equals(role))){
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("JWT Validation Error: " + e.getMessage());
            return false;
        }
    }
}