package com.lov2code.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class GenerateBill {

	FileWriter out;
	
	public void generate(String cardNumber,float total,ArrayList<Transact> cardTransact) throws IOException {
		
		try {
			
			
			System.out.println("Generating file.........");
			String Filename = cardNumber.concat(".dat"); 
			out = new FileWriter("c:/Users/danteeswararao.p/Desktop/TBC/Venicom/"+Filename);
			String val = "Usage Report for Card Number: ";
			String line = val.concat(cardNumber);
			out.append(line);
			out.append("\n");
			out.append("------------------------\n");
			for (Transact transaction : cardTransact) {
				String date = transaction.getdateOfTransact();
				String vendor = transaction.getVendor();
				String amount = Float.toString(transaction.getTransactAmount());
				String line1 = date + "\t" +vendor + "\t" + amount;
				out.append(line1);
				out.append("\n");
			}
			String totalStr = "Total\t\t";
			String totalAmount = Float.toString(total);
			String line3 = totalStr + totalAmount ;
			out.append("------------------------\n");
			out.append(line3);
			out.append("\n");
			System.out.println("file generated.........");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			out.close();
		}
	}
	
}
