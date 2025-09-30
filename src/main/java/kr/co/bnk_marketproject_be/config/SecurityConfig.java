package kr.co.bnk_marketproject_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 헬스체크/테스트는 모두 허용
                        .requestMatchers("/ping", "/actuator/health").permitAll()
                        // 나머지는 지금은 임시로 전부 허용 (원하면 authenticated()로 바꾸세요)
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}
