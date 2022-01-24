package com.sp.humanresourceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/hrms")
public class HrmsController {
	
	@Autowired
	EmployeeFeignClient employeeFeignCLient;

	@GetMapping("/getTaxesPaid")
	@HystrixCommand(fallbackMethod = "handleHystrixFallback")
	public ResponseEntity<?> getEmployeeTax(){
		
		Object obj = employeeFeignCLient.sampleFeggnTest();
		
		ResponseEntity<?> entity = new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
		return entity;
	}
	
public ResponseEntity<?> handleHystrixFallback(){
		
		Object obj = new String("Sharad");
		
		ResponseEntity<?> entity = new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
		return entity;
	}
}
