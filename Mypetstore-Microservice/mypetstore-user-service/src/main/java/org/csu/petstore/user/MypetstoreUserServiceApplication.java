package org.csu.petstore.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("org.csu.petstore.user.persistence")
public class MypetstoreUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypetstoreUserServiceApplication.class, args);
    }

}