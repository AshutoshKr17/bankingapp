package com.bank.bankingapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@Configuration
class WebFluxConfig {

    @Bean
    fun corsFilter(): CorsWebFilter {
        val config = CorsConfiguration()
        config.addAllowedOrigin("http://localhost:3000")
        config.addAllowedMethod("*")
        config.addAllowedHeader("*")
        config.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)

        return CorsWebFilter(source)
    }
}
