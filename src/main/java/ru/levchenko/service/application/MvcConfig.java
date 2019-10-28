package ru.levchenko.service.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

/**
 * Class config for Spring MVC
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Path for user files(images)
     */
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * properties for Emails Sender
     * ALL properties u can see in \src\main\resources\application.properties
     */
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.protocol}")
    private String protocol;
    @Value("${mail.debug}")
    private String debug;

    /**
     *Bean with complete configuration for Emails Sender
     */
    @Bean
    public JavaMailSender javaMailSender(){


        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setPort(port);
        javaMailSender.setHost(host);
        javaMailSender.setPassword(password);
        javaMailSender.setUsername(username);
        javaMailSender.setProtocol(protocol);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.setProperty("mail.debug", debug);

        return javaMailSender;
    }

    /**
     *ResourceHandler for users images locate on path "/img/"
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file://"+uploadPath+"/");
    }

    /**
     *Bean PasswordEncoder for Spring security
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
