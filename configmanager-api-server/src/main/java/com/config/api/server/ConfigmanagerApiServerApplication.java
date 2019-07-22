package com.config.api.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ConfigmanagerApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigmanagerApiServerApplication.class, args);
	}

}
