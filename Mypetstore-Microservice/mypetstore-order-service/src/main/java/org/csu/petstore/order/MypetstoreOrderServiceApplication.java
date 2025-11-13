package org.csu.petstore.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients; // <-- 【【【1. 导入这个】】】

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("org.csu.petstore.order.persistence")
public class MypetstoreOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MypetstoreOrderServiceApplication.class, args);
	}
}