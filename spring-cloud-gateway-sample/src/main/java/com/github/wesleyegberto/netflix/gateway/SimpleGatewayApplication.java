package com.github.wesleyegberto.netflix.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(
                p -> p.path("/get")
                    .filters(f -> f.addRequestHeader("My-Header", "My-Value"))
                    .uri("http://httpbin.org")
            )
            // Routing a service on kubernetes cluster
            .route("k8s-some-service", r -> r
                    .path("/some-service")
                    .uri("http://some-service.default.svc.cluster.local")
            )
            .route("route-with-hystrix",
                    p -> p.host("*.wesley.com")
                    .filters(f -> f.hystrix(c -> c
                            .setName("route")
                            .setFallbackUri("forward:/api/fallback"))
                    )
                    .uri("http://httpbin.org:80")
            )
            .build();
    }
}

@RestController
@RequestMapping("/api/fallback")
class FallbackController {
    @GetMapping
    public String fallback() {
        return "fallback response";
    }
}