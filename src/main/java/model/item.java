package model;

public class item {
	private product product;
	private int quantity;
	private double price;
	private product_sizee pz;
	private size s;
	
	public item(product product, int quantity, double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	public item(int quantity, double price, product_sizee pz) {
		this.quantity = quantity;
		this.price = price;
		this.pz = pz;
	}
	
	public item(product product, int quantity, double price, product_sizee pz) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.pz = pz;
	}
	
	public item(product product, int quantity, double price, product_sizee pz, size s) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.pz = pz;
		this.s = s;
	}
	
	public size getS() {
		return s;
	}

	public void setS(size s) {
		this.s = s;
	}

	public product_sizee getPz() {
		return pz;
	}

	public void setPz(product_sizee pz) {
		this.pz = pz;
	}

	public item() {
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
