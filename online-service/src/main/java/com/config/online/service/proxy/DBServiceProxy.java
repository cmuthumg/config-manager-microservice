package com.config.online.service.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.config.online.service.bean.RequestBean;
import com.config.online.service.bean.ResponseBean;

@FeignClient(name="configmanager-api-server")
@RibbonClient(name="db-service")
public interface DBServiceProxy {

	@GetMapping("/db-service/all/{servicename}")
	ResponseEntity<ResponseBean> getAllConfig(@PathVariable("servicename") String servicename);

	@GetMapping("/db-service/get/{servicename}/{resourcename}/{status}")
	ResponseEntity<ResponseBean> getConfigData(@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, @PathVariable("status") String status);

	@PostMapping("/db-service/save/{servicename}")
	ResponseEntity<ResponseBean> saveConfigData(@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean);

	@PutMapping("/db-service/update/{servicename}")
	ResponseEntity<ResponseBean> updateConfigData(@PathVariable("servicename") String serviceName,
			@RequestBody RequestBean requestBean);

	@DeleteMapping("/db-service/delete/{servicename}/{resourcename}/{status}")
	ResponseEntity<ResponseBean> deleteConfigData(@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, @PathVariable("status") String status);
}
