package com.passkeys

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .formLogin(Customizer.withDefaults())
            .webAuthn { it ->
                it.rpName("Passkeys Demo")
                    .rpId("localhost")
                    .allowedOrigins("http://localhost:8080")
            }
            .authorizeHttpRequests { it ->
                it.requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
            }

        return http.build()
    }

    @Bean
    fun inMemoryUserDetailManager(): InMemoryUserDetailsManager {
        val user = User.withUsername("sendkite")
            .password("{noop}pw")
            .roles("ADMIN","USER")
            .build()

        val user2 = User.withUsername("hmin")
            .password("{noop}pw")
            .roles("USER")
            .build()


        return InMemoryUserDetailsManager(user, user2)
    }
}