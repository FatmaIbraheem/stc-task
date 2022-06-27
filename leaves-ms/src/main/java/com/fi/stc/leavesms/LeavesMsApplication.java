package com.fi.stc.leavesms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeavesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeavesMsApplication.class, args);
	}

}
