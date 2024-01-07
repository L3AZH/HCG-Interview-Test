package com.l3azh.hcginterviewservicesbooking.hcginterviewservicesbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class HcgInterviewServicesBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcgInterviewServicesBookingApplication.class, args);
	}

}
