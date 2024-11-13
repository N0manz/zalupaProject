package project.zalupa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // указываем страницу для логина
                        .permitAll()           // разрешаем всем доступ к странице логина
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")  // указываем URL для логаута
                        .logoutSuccessUrl("/login?logout")  // перенаправление после успешного логаута
                        .permitAll()
                );

        return http.build();
    }

}



