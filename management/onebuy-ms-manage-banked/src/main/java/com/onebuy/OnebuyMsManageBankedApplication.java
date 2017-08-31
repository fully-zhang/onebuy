package com.onebuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableWebMvc
public class OnebuyMsManageBankedApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnebuyMsManageBankedApplication.class, args);
	}
}
