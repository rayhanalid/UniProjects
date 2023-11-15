/*
package com.PATCH.PetDatingApp.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("reset-password-service", r -> r.path("/user/resetpassword/**")
                        .filters(f -> f
                                .rewritePath("/user/resetpassword/(?<token>.*)", "/user/resetpassword/${token}")
                                .addRequestHeader("Content-Type", "application/json")
                        )
                        .uri("http://localhost:8083")) // Replace with the appropriate URI for your reset password service
                .route("forgot-password-service", r -> r.path("http:///user/forgotpassword?email=String")
                        .filters(f -> f
                                .rewritePath("/user/forgotpassword/(?<token>.*)", "/user/forgotpassword/${token}")
                                .addRequestHeader("Content-Type", "application/json")
                        )
                        .uri("http://localhost:8084")) // Replace with the appropriate URI for your forgot password service
                // Add more routes for your other services as needed
                .build();
    }
}
*/
