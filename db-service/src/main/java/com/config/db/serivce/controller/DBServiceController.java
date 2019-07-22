package com.config.db.serivce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.db.serivce.bean.RequestBean;
import com.config.db.serivce.bean.ResponseBean;
import com.config.db.serivce.registry.ServiceRegistry;

@RestController
@RequestMapping("/dbservice")
public class DBServiceController {

	@Autowired
	private ServiceRegistry<RequestBean> serviceRegistry;

	@GetMapping("/hello")
	public String hello() {
		return "Hello DBserivce !!!";
	}

	@GetMapping("/all/{servicename}")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<ResponseBean> getAllConfig(
			@PathVariable("servicename") String servicename) {

		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity(
				serviceRegistry.getService(servicename).getAllService(), HttpStatus.OK);
		return responseEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/get/{servicename}/{resourcename}/{status}")
	public ResponseEntity<ResponseBean> getConfigData(
			@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, 
			@PathVariable("status") String status) {

		ResponseEntity<ResponseBean> responseEntity = new ResponseEntity(
				serviceRegistry.getService(servicename).getConfigData(resourcename, status), HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/save/{servicename}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity saveConfigData(
			@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean) {

		serviceRegistry.getService(serviceName).saveconfigData(requestBean);

		ResponseEntity responseEntity = new ResponseEntity("Saved Successfull !", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update/{servicename}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity updateConfigData(
			@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean) {

		serviceRegistry.getService(serviceName).updateConfigData(requestBean);

		ResponseEntity responseEntity = new ResponseEntity("Updated Successfull !", HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{servicename}/{resourcename}/{status}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity deleteConfigData(
			@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, 
			@PathVariable("status") String status) {

		serviceRegistry.getService(servicename).deleteConfigData(resourcename, status);

		ResponseEntity responseEntity = new ResponseEntity("Deleted Successfull !", HttpStatus.OK);
		return responseEntity;
	}

}
