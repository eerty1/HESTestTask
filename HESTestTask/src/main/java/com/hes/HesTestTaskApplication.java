package com.hes;

import com.hes.security.jwt.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class HesTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(HesTestTaskApplication.class, args);
    }
}
