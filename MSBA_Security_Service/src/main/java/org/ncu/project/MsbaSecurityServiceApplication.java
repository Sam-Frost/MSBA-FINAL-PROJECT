package org.ncu.project;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class MsbaSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsbaSecurityServiceApplication.class, args);
	}

}
