package com.jawsome.parkshark.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.jawsome.parkshark")
public class JPAConfig {
}
