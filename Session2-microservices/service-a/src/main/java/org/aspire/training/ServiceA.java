package org.aspire.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceA {

	public static void main(String[] args) {
		SpringApplication.run(ServiceA.class, args);
	}
}
