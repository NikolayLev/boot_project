package ru.levchenko.service.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "ru.levchenko.service")
@EnableJpaRepositories(basePackages = "ru.levchenko.service.repositories")
@EntityScan(basePackages = "ru.levchenko.service.models")
public class App {


    public static void main(String[] args) {

        SpringApplication.run(App.class);
    }
}
