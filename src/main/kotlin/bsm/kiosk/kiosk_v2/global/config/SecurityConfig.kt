package bsm.kiosk.kiosk_v2.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http
      .csrf { it.disable() }
      .httpBasic { it.disable() }
      .formLogin { it.disable() }
      .authorizeHttpRequests {
        it.requestMatchers("/kiosk/auth/signIn").permitAll()
          .anyRequest().permitAll()
      }
      .sessionManagement {
        it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      }

    return http.build()
  }
}
