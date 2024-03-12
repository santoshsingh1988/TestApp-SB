package com.webapp.bankingportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingportalApplication.class, args);

		System.out.println("Test App Started.");

		printJsonInfoToPDF();

	}



public static void printJsonInfoToPDF(){

	System.out.println("Print JSON to PDF Code.");

	


}




}
