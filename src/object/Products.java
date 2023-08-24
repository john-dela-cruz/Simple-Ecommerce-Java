package object;

public class Products {
	
	private String productName;
	private int productPrice;
	
	public Products(String productName, int productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getName() {
		return productName;
	}
	
	public int getPrice() {
		return productPrice;
	}
}
