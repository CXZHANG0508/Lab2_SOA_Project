package org.csu.petstore.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MypetstoreGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MypetstoreGatewayApplication.class, args);
	}

}