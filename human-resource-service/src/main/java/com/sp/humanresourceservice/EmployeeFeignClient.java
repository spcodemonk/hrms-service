package com.sp.humanresourceservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="EMPLOYEE-SERVICE", configuration = CustomFeignConfig.class)
public interface  EmployeeFeignClient {

	@GetMapping("/emp/allEmps")
	public Object sampleFeggnTest();
}