package com.bigramhistogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bigramhistogram")
public class BigramHistogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigramHistogramApplication.class, args);
		
	}

}
