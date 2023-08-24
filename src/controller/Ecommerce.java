package controller;

import model.EcomMenu;
import function.Functions;

public class Ecommerce {

	public static void main(String[] args) {
		
		int choice;
		int itemChoice;
		String product;
		int price;
		int payment;
		int totalPrice;
		
		EcomMenu menu = new EcomMenu();
		
		choice = menu.displayMenu();
		
		if(choice == 1){
			
			Functions.displayCart();
			
		}
		else if(choice == 2){
			
			itemChoice = menu.addItem();
			product = Functions.getItemName(itemChoice);
			price = Functions.getItemPrice(itemChoice);
			Functions.addItemToCart(product, price);
			
		}
		else if(choice == 3){
			
			Functions.displayCart();
			itemChoice = menu.removeItem();
			Functions.removeItemFromCart(itemChoice);
			
		}
		else if(choice == 4){
			
			Functions.displayCart();
			totalPrice = Functions.getTotalPrice();
			System.out.println("TOTAL - PHP " + totalPrice);
			payment = menu.getPayment();
			payment = Functions.checkPayment(totalPrice, payment);
			Functions.getReceipt(totalPrice, payment);
			Functions.displayReceipt();
			
		}
		else{
			System.out.println("Input Invalid!");
		}
	}

}
