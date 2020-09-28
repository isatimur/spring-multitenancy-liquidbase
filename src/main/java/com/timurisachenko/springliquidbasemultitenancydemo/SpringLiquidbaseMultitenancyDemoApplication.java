package com.timurisachenko.springliquidbasemultitenancydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        exclude = {org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration.class}
)
public class SpringLiquidbaseMultitenancyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLiquidbaseMultitenancyDemoApplication.class, args);
    }

}

