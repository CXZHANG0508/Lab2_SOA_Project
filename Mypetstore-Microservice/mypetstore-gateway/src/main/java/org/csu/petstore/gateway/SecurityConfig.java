package org.csu.petstore.gateway; // (确保包名正确)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity // 1. 使用 @EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) { // 2. 注入 ServerHttpSecurity
        http
                // 3. 启用CORS (它会自动查找我们下面定义的 Reactive CORS Bean)
                .cors(cors -> {})
                // 4. 禁用CSRF
                .csrf(csrf -> csrf.disable())
                // 5. 使用 authorizeExchange (而不是 authorizeHttpRequests)
                .authorizeExchange(auth -> auth
                        // 6. (关键) 允许所有的 OPTIONS 预检请求
                        .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // 7. 允许所有其他请求（网关只做转发）
                        .anyExchange().permitAll()
                );

        return http.build();
    }
}