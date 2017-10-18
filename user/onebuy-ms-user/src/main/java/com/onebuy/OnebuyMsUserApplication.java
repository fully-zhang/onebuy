package com.onebuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnebuyMsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnebuyMsUserApplication.class, args);
	}
}
