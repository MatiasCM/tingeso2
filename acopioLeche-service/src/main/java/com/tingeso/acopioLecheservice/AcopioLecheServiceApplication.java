package com.tingeso.acopioLecheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AcopioLecheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcopioLecheServiceApplication.class, args);
	}

}
