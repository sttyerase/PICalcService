package com.dbmi.demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbmi.money.Calculation;

@SpringBootApplication
@RestController
public class PICalcApplication {
    private int months          = 48;
    private double principal    = 25000.00;
    private double interestRate = 3.85;

	@GetMapping("/reference")
	public String home() {
	    System.out.format("Calculating: months %d , principal $%,3.2f, interestRate  %3.2f%% \n", months, principal, interestRate);
		return new Calculation().getCalculation(months, principal, interestRate);
	} // HOME()

    @GetMapping("/calculate/{months}/{principal}/{interestrate}")
    public String calculate(@PathVariable("months") Integer months,@PathVariable("principal") Double principal, @PathVariable("interestrate") Double interestRate) {
	    System.out.format("Calculating: months %d , principal $%,3.2f, interestRate  %3.2f%% \n", months, principal, interestRate);
		return new Calculation().getCalculation(months, principal, interestRate);
    } // GETCROPSBYID(LONG)

	public static void main(String[] args) {
		SpringApplication.run(PICalcApplication.class, args);
	} // MAIN(STRING[])

} // CLASS
