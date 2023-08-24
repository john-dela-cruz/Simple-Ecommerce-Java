package model;

import interfaces.Interfaces;
import utility.Helper;

public class EcomMenu implements Interfaces.EcomAddItem,Interfaces.EcomCheckout,Interfaces.EcomInterface,Interfaces.EcomRemoveItem{
	
	public int displayMenu(){
		int choice = 0;
		
		System.out.println("Shopping Cart \n");
		System.out.println("1. View Cart");
		System.out.println("2. Add to Cart");
		System.out.println("3. Remove from Cart");
		System.out.println("4. Checkout \n");
		choice = Helper.readInt("choice");
		
		return choice;
	}
	
	public int addItem(){
		int choice = 0;
		
		System.out.println("Product List \n");
		System.out.println("1. AT2020 microphone - PHP 5500");
		System.out.println("2. E-22 audio interface - PHP 3000");
		System.out.println("3. Blue Yeti microphone - PHP 9000");
		System.out.println("4. Focusrite Scarlett audio interface - PHP 7000 \n");
		choice = Helper.readInt("choice");
		
		return choice;
	}
	
	public int removeItem(){
		int choice = 0;
		
		choice = Helper.readInt("the ID of the item you want to remove");
		
		return choice;
	}
	
	public int getPayment(){
		
		int payment = 0;
		
		payment = Helper.readInt("payment");
		
		return payment;
		
	}
}
