package com.tekone.tekone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class TekoneApplication  {	

	public static void main(String[] args) {
		SpringApplication.run(TekoneApplication.class, args);
	}

}
