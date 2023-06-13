package com.tingeso.grasaSolidoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GrasaSolidoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrasaSolidoServiceApplication.class, args);
	}

}
