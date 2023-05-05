package model;

import java.util.Objects;

public class product_sizee {
	private String id_product;
	private String id_size;
	private int quantity;
	
	public product_sizee(String id_product, String id_size, int quantity) {
		this.id_product = id_product;
		this.id_size = id_size;
		this.quantity = quantity;
	}

	public product_sizee() {
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getId_size() {
		return id_size;
	}

	public void setId_size(String id_size) {
		this.id_size = id_size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "product_sizee [id_product=" + id_product + ", id_size=" + id_size + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_product, id_size, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product_sizee other = (product_sizee) obj;
		return Objects.equals(id_product, other.id_product) && Objects.equals(id_size, other.id_size);
	}
	
	
	
}
