package com.example.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import static jdk.internal.classfile.Classfile.build;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r ->
						r.path("/clients/**").uri("lb://SERVICE-CLIENT"))
		 .build();

		 }

}