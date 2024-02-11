package com.devops.praticedevop;

import com.devops.praticedevop.service.impl.CalculatorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PracticeDevopsApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(PracticeDevopsApplication.class, args);
		CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

		calculatorService.multiOperation_("4+8+9");
	}

}
