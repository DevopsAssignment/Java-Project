package com.lov2code.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;


public class TransactFileReader{
	private ArrayList<Transact> transactList;
	
	public TransactFileReader(String fileNameWithPath)throws TransactException{
		
		BufferedReader reader=null;
		FileReader fileReader=null;
		
		transactList =new ArrayList<Transact>();
		try{
			 fileReader=new FileReader(fileNameWithPath);
			 reader=new BufferedReader(fileReader);
			
			 String line=reader.readLine();
				
				while(line !=null){
					//System.out.println(line);
					Transact t= new Transact(line);
					transactList.add(t);
					line=reader.readLine();
					//System.out.println(t);
					//t.equals(t);

			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new TransactException("data file'"+fileNameWithPath+"'not found."+e.getMessage());
		}catch (IOException e){
			e.printStackTrace();
			throw new TransactException("error happened when reading the file"+fileNameWithPath+"exception message"+e.getMessage());
		} catch(Exception e){}
		finally{
			try{
				if(fileReader != null){
				fileReader.close();
				}
				if(fileReader != null){
				reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			} 
	}
	}
	public ArrayList<Transact> gettransactList() {
            return transactList;
    }

}
			