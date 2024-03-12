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
	String dummyJSON = "{ \"id\": \"0001\", \"type\": \"donut\", \"name\": \"Cake\", \"image\": { \"url\": \"images//0001.jpg\", \"width\": 200, \"height\": 200 }, \"thumbnail\": { \"url\": \"images//thumbnails//0001.jpg\", \"width\": 32, \"height\": 32 } }";

System.out.println(dummyJSON);

}




}
