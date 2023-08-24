package interfaces;

public class Interfaces {
	public interface EcomAddItem {
		
		public int addItem();
	}
	
	public interface EcomCheckout {
		
		public int getPayment();
	}
	
	public interface EcomInterface {
		
		public int displayMenu();
	}
	
	public interface EcomRemoveItem {
		
		public int removeItem();
	}
}
