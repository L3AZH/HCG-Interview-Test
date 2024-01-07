package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class HcgInterviewServicesInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcgInterviewServicesInventoryApplication.class, args);
	}

}
