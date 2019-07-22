package com.config.online.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.config.online.service.proxy")
public class OnlineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineServiceApplication.class, args);
	}

}
