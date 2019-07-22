package com.config.online.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.online.service.bean.RequestBean;
import com.config.online.service.bean.ResponseBean;
import com.config.online.service.proxy.DBServiceProxy;

@RestController
public class OnlineServiceController {
	
	
	@Autowired
	DBServiceProxy dbServiceProxy;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Online Service";
	}
	
	@GetMapping("/all/{servicename}")
	public ResponseEntity<List<ResponseBean>> getAllConfig(
			@PathVariable("servicename") String servicename) {
		return dbServiceProxy.getAllConfig(servicename);
	}

	@GetMapping("/get/{servicename}/{resourcename}/{status}")
	public ResponseEntity<ResponseBean> getConfigData(
			@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, 
			@PathVariable("status") String status) {

		
		return dbServiceProxy.getConfigData(servicename,resourcename, status);
	}

	@PostMapping("/save/{servicename}")
	public ResponseEntity<String> saveConfigData(
			@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean) {
		return dbServiceProxy.saveConfigData(serviceName,requestBean);
	}

	@PutMapping("/update/{servicename}")
	public ResponseEntity<String> updateConfigData(
			@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean) {

		return dbServiceProxy.updateConfigData(serviceName,requestBean);
	}
	
	@DeleteMapping("/delete/{servicename}/{resourcename}/{status}")
	public ResponseEntity<String> deleteConfigData(
			@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, 
			@PathVariable("status") String status) {
		return dbServiceProxy.deleteConfigData(servicename,resourcename, status);
	}
	

}
