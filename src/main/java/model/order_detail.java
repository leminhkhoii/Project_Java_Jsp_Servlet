package model;

import java.util.Objects;

public class order_detail {
	private int id_order;
	private String id_product;
	private int quantity;
	private double price;
	private String size;
	
	
	public order_detail(int id_order, String id_product, int quantity, double price) {
		this.id_order = id_order;
		this.id_product = id_product;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public order_detail(int id_order, String id_product, int quantity, double price, String size) {
		this.id_order = id_order;
		this.id_product = id_product;
		this.quantity = quantity;
		this.price = price;
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public order_detail() {
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
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
		return "order_detail [id_order=" + id_order + ", id_product=" + id_product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_order, id_product, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		order_detail other = (order_detail) obj;
		return Objects.equals(id_order, other.id_order) && Objects.equals(id_product, other.id_product);
	}
	
	
}
