package com.config.online.service.proxy;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.config.online.service.bean.RequestBean;
import com.config.online.service.bean.ResponseBean;

@FeignClient(name="configmanager-api-server")
@RibbonClient(name="db-service")
public interface DBServiceProxy {

	@GetMapping("/db-service/all/{servicename}")
	ResponseEntity<List<ResponseBean>> getAllConfig(@PathVariable("servicename") String servicename);

	@GetMapping("/db-service/get/{servicename}/{resourcename}/{status}")
	ResponseEntity<ResponseBean> getConfigData(@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, @PathVariable("status") String status);

	@PostMapping(path="/db-service/save/{servicename}")
	ResponseEntity<String> saveConfigData(@PathVariable("servicename") String serviceName,
			RequestBean requestBean);

	@PutMapping("/db-service/update/{servicename}")
	ResponseEntity<String> updateConfigData(@PathVariable("servicename") String serviceName,
			RequestBean requestBean);

	@DeleteMapping("/db-service/delete/{servicename}/{resourcename}/{status}")
	ResponseEntity<String> deleteConfigData(@PathVariable("servicename") String servicename,
			@PathVariable("resourcename") String resourcename, @PathVariable("status") String status);
}
