package com.lov2code.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class AmountCalculator{
	
	public static void main(String[] args)throws Exception{
		try{
				 TransactFileReader reader= new TransactFileReader("c:/Users/danteeswararao.p/Desktop/TBC/Venicom/test.csv");
                 ArrayList <Transact> transactList = reader.gettransactList();
				 Map<String, ArrayList<Transact>> map = 
				new HashMap<String, ArrayList<Transact>>();
				try{
					for (Transact transaction : transactList) {
						String cardNumber = transaction.getcardnumber();
						if (!map.containsKey(cardNumber)) {
							ArrayList<Transact> cardTransact = 
								new ArrayList<Transact>();
							cardTransact.add(transaction);
							map.put(cardNumber, cardTransact);
						} else {
							ArrayList<Transact> cardTransact = 
								map.get(cardNumber);
							cardTransact.add(transaction);
						}
					}
			}catch(Exception e){
						
			}
			
				
			GenerateBill bg = new GenerateBill();	
			Set<String> cardNumbers = map.keySet();
			for (String cardNumber : cardNumbers) {
				float total = 0 ;
				System.out.println("Card Number: " + cardNumber);
				ArrayList<Transact> cardTransact = 
					map.get(cardNumber);
				for (Transact transaction : cardTransact) {
					System.out.print("    " + transaction.getVendor() + "  ");
					System.out.println("    " + transaction.getTransactAmount());
					total = total + transaction.getTransactAmount();
				}
				System.out.print("    Total");
				System.out.println("    " + total);
				bg.generate(cardNumber ,total,cardTransact);	
			}
			}catch(TransactException te){
			}
	}
}