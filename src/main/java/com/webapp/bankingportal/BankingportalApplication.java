package com.webapp.bankingportal;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.ByteArray;

@SpringBootApplication
public class BankingportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingportalApplication.class, args);

		System.out.println("Test App Started.");

		try {
			printJsonInfoToPDF();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



public static void printJsonInfoToPDF() throws Exception{

	System.out.println("Print JSON to PDF Code.");
	String dummyJSON = "{ \"id\": \"0001\", \"type\": \"donut\", \"name\": \"Cake\", \"image\": { \"url\": \"images//0001.jpg\", \"width\": 200, \"height\": 200 }, \"thumbnail\": { \"url\": \"images//thumbnails//0001.jpg\", \"width\": 32, \"height\": 32 } }";

	System.out.println(dummyJSON);

	ObjectMapper mapper = new ObjectMapper();

	JsonNode rootNode = mapper.readTree(dummyJSON);


	createPDF(rootNode);

}

public static void createPDF(JsonNode node) throws Exception{

	Document document = new Document();
	FileOutputStream outputStream = new FileOutputStream("output.pdf");

	PdfWriter.getInstance(document, outputStream);

	document.open();
	addContent(document, node);
	document.close();

}

public static void addContent(Document document, JsonNode node) throws Exception{

	Iterator<Map.Entry<String,JsonNode>> fields = node.fields();

	while(fields.hasNext()){
		Map.Entry<String,JsonNode> entry = fields.next();
		String key = entry.getKey();
		JsonNode value = entry.getValue();

		if(value.isObject()){
			addHeading(document, key);
			addContent(document, value);
		}else{
			
			addContentLine(document, key + " : " + value.asText());
		}

	}

}

public static void addHeading(Document document, String heading) throws Exception{
	document.add(new Paragraph(heading));
}

public static void addContentLine(Document document, String content) throws Exception{
	document.add(new Paragraph(content));
}




}
