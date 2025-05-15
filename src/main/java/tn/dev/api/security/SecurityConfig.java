package tn.dev.api.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Disable Cross-Site Request Forgery (CSRF) protection
            .csrf(csrf -> csrf.disable())
            // Disable Cross-Origin Resource Sharing (CORS) protection
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration corsConfig = new CorsConfiguration();
                corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                corsConfig.setAllowedMethods(Collections.singletonList("*"));
                corsConfig.setAllowedHeaders(Collections.singletonList("*"));
                corsConfig.setExposedHeaders(Collections.singletonList("Authorization"));
                return corsConfig;
            }))
            .authorizeHttpRequests(authRequest ->
                authRequest
                .requestMatchers(HttpMethod.GET,"/api/all").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/getById/**").permitAll()
                .anyRequest().authenticated())
            // Add a JWT authentication filter
            .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
