package model;

import java.util.Objects;

public class product_size {
	private product product;
	private size size;
	private int quantity;
	
	public product_size(model.product product, model.size size, int quantity) {
		this.product = product;
		this.size = size;
		this.quantity = quantity;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public size getSize() {
		return size;
	}

	public void setSize(size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "product_size [product=" + product + ", size=" + size + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, quantity, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_size other = (product_size) obj;
		return Objects.equals(product, other.product) && quantity == other.quantity && Objects.equals(size, other.size);
	}
	
	
}
