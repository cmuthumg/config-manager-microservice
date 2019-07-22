package com.config.db.serivce.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.config.db.serivce.registry.ServiceRegistry;

@Configuration
public class ServiceConfig {

	@Bean
	public FactoryBean<?> factoryBean() {
		final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(ServiceRegistry.class);
		return bean;
	}
}
