package com.jawsome.parkshark;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParksharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParksharkApplication.class, args);
    }

    @Bean
    public OpenAPI configureOpenApi() {
        return new OpenAPI().info(new Info().title("Parkshark by Jaw-some").description("The best project ever!"));
    }
}

