package com.sapient.auction.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuctionItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionItemServiceApplication.class, args);
	}
}
