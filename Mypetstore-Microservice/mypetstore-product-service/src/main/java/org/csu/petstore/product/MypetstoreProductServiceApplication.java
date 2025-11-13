package org.csu.petstore.product;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("org.csu.petstore.product.persistence")
public class MypetstoreProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypetstoreProductServiceApplication.class, args);
    }

}