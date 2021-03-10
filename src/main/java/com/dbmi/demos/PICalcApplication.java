package com.dbmi.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbmi.money.CalculationService;

@SpringBootApplication
@RestController
public class PICalcApplication {

	@GetMapping("/reference")
	public String reference() {  // REFERENCE METHOD FOR TESTING CONNECTIVITY
		int months          = 48;
		double principal    = 25000.00;
		double interestRate = 3.85;
	    System.out.format("Calculating: months %d , principal $%,3.2f, interestRate  %3.2f%% \n", months, principal, interestRate);
		HttpHeaders myHeaders = new HttpHeaders();
		myHeaders.add("Content-Type","application/json");
		return new CalculationService().getCalculation(months, principal, interestRate);
	} // HOME()

    @GetMapping("/calculate/{months}/{principal}/{interestrate}")
    public String calculate(@PathVariable("months") Integer months,@PathVariable("principal") Double principal, @PathVariable("interestrate") Double interestRate) {
	    System.out.format("Calculating: months %d , principal $%,3.2f, interestRate  %3.2f%% \n", months, principal, interestRate);
		HttpHeaders myHeaders = new HttpHeaders();
		myHeaders.add("content-type","application/json");
		return new CalculationService().getCalculation(months, principal, interestRate);
    } // GETCROPSBYID(LONG)

	public static void main(String[] args) {
		SpringApplication.run(PICalcApplication.class, args);
	} // MAIN(STRING[])

} // CLASS
