package com.devops.praticedevop;

import com.devops.praticedevop.service.impl.CalculatorServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeDevopsApplication {


	public static void main(String[] args) {
		SpringApplication.run(PracticeDevopsApplication.class, args);
		CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

		calculatorService.multiOperation_("4+8+9");
	}

}
