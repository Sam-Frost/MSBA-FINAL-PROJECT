package org.ncu.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsbaDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsbaDiscoveryServiceApplication.class, args);
	}

}
