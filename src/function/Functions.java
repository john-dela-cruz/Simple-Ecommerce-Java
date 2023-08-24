package function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utility.Helper;
import object.Products;

public class Functions {
	
	public static String getItemName(int id){
		
		String productName = null;
		int counter = 0;
		
		List<Products> itemList = new ArrayList<>();
		itemList.add(new Products("AT2020 microphone",5500));
		itemList.add(new Products("E-22 audio interface",3000));
		itemList.add(new Products("Blue Yeti microphone",9000));
		itemList.add(new Products("Focusrite Scarlett audio interface",7000));
		
		Iterator<Products> itr = itemList.iterator();
		
		while(itr.hasNext() && counter != id){
			productName = itr.next().getName();
			counter++;
		}
		
		return productName;
	}
	
	public static int getItemPrice(int id){
		
		int productPrice = 0;
		int counter = 0;
		
		List<Products> itemList = new ArrayList<>();
		itemList.add(new Products("AT2020 microphone",5500));
		itemList.add(new Products("E-22 audio interface",3000));
		itemList.add(new Products("Blue Yeti microphone",9000));
		itemList.add(new Products("Focusrite Scarlett audio interface",7000));
		
		Iterator<Products> itr = itemList.iterator();
		
		while(itr.hasNext() && counter != id){
			productPrice = itr.next().getPrice();
			counter++;
		}
		
		return productPrice;
	}
	
	public static void checkTextFile(String textFile){
		try{
			BufferedReader br = new BufferedReader(new FileReader(textFile));
			if(br.readLine() == null){
				System.out.println("Cart is Empty \n");
			}
			else{
				System.out.println("ID | PRODUCT | PRICE \n");
			}
			br.close();
		}
		catch(IOException ioe) {
			
		}
	}
	
	public static void displayCart(){
		String line;
		String textFile = "cart.txt";
		int id = 0;
		
		Functions.checkTextFile(textFile);
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(textFile));
			while((line = br.readLine()) != null){
				String[] item = line.split(",");
				System.out.println(id + " | " + item[0] + " | PHP " + item[1]);
				id++;
			}
			
			br.close();
			System.out.println("");
		}
		catch(IOException ioe) {
			System.err.println("Cart is empty");
		}
		
	}
	
	public static void addItemToCart(String productName, int productPrice){
		try{
			
			FileWriter fw = new FileWriter("cart.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			
				
			StringBuilder builder = new StringBuilder();
			builder.append(productName + ",");
			builder.append(productPrice + "\n");
			pw.write(builder.toString());
			pw.close();
			
			System.out.println("Item added to Cart Successfully!");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void removeItemFromCart(int id){
		String filepath = "cart.txt";
		int counter = 0;
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String line;
		
		try{
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			while((line = br.readLine()) != null){
				String[] item = line.split(",");
				
				if(counter != id){
					pw.println(item[0] + "," + item[1]);
				}
				counter++;
			}
			
			br.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File current = new File(filepath);
			newFile.renameTo(current);
			System.out.println("Item removed from Cart!");
		}
		catch(IOException ioe) {
			System.err.println("Error");
		}
	}
	
	public static int getTotalPrice(){
		String line;
		String textFile = "cart.txt";
		int sum = 0;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(textFile));
			while((line = br.readLine()) != null){
				String[] item = line.split(",");
				sum += Integer.parseInt(item[1]);
			}
			
			br.close();
		}
		catch(IOException ioe) {
			System.err.println("Cart is empty");
		}
		
		return sum;
	}
	
	public static int checkPayment(int totalPrice, int payment){
		
		while(payment < totalPrice){
			System.out.println("The amount you entered is insufficient. Try Again!");
			payment = Helper.readInt("payment");
		}
		return payment;
	}
	
	public static void getReceipt(int totalPrice, int payment){
		
		int change;
		
		change = payment - totalPrice;
		
		String filepath = "cart.txt";
		String receiptFile = "receipt.txt";
		String line;
		
		try{
			FileWriter fw = new FileWriter(receiptFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			while((line = br.readLine()) != null){
				String[] item = line.split(",");
				
				pw.println(item[0] + "," + item[1]);
			}
			
			pw.println("TOTAL" + "," + totalPrice);
			pw.println("PAYMENT" + "," + payment);
			pw.println("CHANGE" + "," + change);
			
			br.close();
			pw.flush();
			pw.close();
			System.out.println("Payment Successful! \n");
		}
		catch(IOException ioe) {
			System.err.println("Error");
		}
	}
	
	public static void displayReceipt(){
		String line;
		String textFile = "receipt.txt";
		File receiptFile = new File(textFile);
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(textFile));
			while((line = br.readLine()) != null){
				String[] item = line.split(",");
				System.out.println(item[0] + " | PHP " + item[1]);
			}
			
			br.close();
			receiptFile.delete();
		}
		catch(IOException ioe) {
			System.err.println("Cart is empty");
		}
	}
}
