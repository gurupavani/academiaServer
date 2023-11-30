package com.iiitbesd.academicerp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class AcademicerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicerpApplication.class, args);
	}


}
