package com.iiitbesd.academicerp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@SpringBootApplication
//@RestController
public class AcademicerpApplication {
//	private static final Logger logger = LogManager.getLogManager().getLogger(AcademicerpApplication.getClass());
	public static void main(String[] args) {

		SpringApplication.run(AcademicerpApplication.class, args);
	}


}
