package com.lov2code.example;



public class Transact{
	
	protected String cardnumber;
	protected String dateOfTransact;
	protected String vendor;
	protected float transactAmount;
	
	
	public  Transact(String details)throws Exception{
		String data[]=details.split(",");
		this.cardnumber=data[0];
		this.dateOfTransact=data[1];
		/* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateOfTransact = simpleDateFormat.parse(data[1]); */
		//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//this.dateOfTransact=Date.parse(data[1], formatter);
		this.vendor=data[2];
		this.transactAmount=Float.parseFloat(data[3]);
	}
	
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public float getTransactAmount() {
		return transactAmount;
	}
	public void setTransactAmount(float transactAmount) {
		this.transactAmount = transactAmount;
	}
	
	public String getcardnumber(){
		return cardnumber;
	}
	public String getdateOfTransact(){
		return dateOfTransact;
	}
	public String toString(){
		return
			"[cardnumber="+cardnumber+";"+
			"dateOfTransact="+dateOfTransact+";"+
			"vendor="+vendor+";"+
			"transactAmount="+transactAmount+";"+"]";
	}
	/* public boolean equals(Object object){
			Transact transact=(Transact)object;
			System.out.println("equals.this="+cardnumber+";"+"other:"+transact.getcardnumber());
			if((this.cardnumber).equals(transact.getcardnumber())){
				String filePath="D://"+cardnumber+".dat";
				FileWriter fr = null;
				try {
					fr = new FileWriter(filePath);
					String temp=transact.getdateOfTransact();
					fr.append(temp);
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					//close resources
					try {
						if(fr != null){
						fr.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		 }
		 return true;
	} */
}
	