package model;

import java.util.Objects;

public class product {
	private String id_product;
	private String nameProduct;
	private double price;
	private String id_producer;
	private String id_producttype;
	private String description;
	private String url;
	private String nameSize;
	private int quantity;
	
	public product(String id_product, String nameProduct, double price, String id_producer, String description, String url) {
		this.id_product = id_product;
		this.nameProduct = nameProduct;
		this.price = price;
		this.id_producer = id_producer;
		this.description = description;
		this.url = url;
	}
	
	public product(String id_product, String nameProduct, double price, String id_producer, String id_producttype,
			String description, String url, int quantity) {
		super();
		this.id_product = id_product;
		this.nameProduct = nameProduct;
		this.price = price;
		this.id_producer = id_producer;
		this.id_producttype = id_producttype;
		this.description = description;
		this.url = url;
		this.quantity=quantity;
	}
	
	public product(String id_product, String nameProduct, double price, String id_producer, String id_producttype,
			String description, String url) {
		super();
		this.id_product = id_product;
		this.nameProduct = nameProduct;
		this.price = price;
		this.id_producer = id_producer;
		this.id_producttype = id_producttype;
		this.description = description;
		this.url = url;
	}
	public product(String id_product, String nameProduct, double price, String id_producer, String id_producttype,
			String description, String url, String nameSize, int quantity) {
		this.id_product = id_product;
		this.nameProduct = nameProduct;
		this.price = price;
		this.id_producer = id_producer;
		this.id_producttype = id_producttype;
		this.description = description;
		this.url = url;
		this.nameSize = nameSize;
		this.quantity = quantity;
	}

	public product() {
	}

	
	
	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getId_producer() {
		return id_producer;
	}

	public void setId_producer(String id_producer) {
		this.id_producer = id_producer;
	}

	public String getNameSize() {
		return nameSize;
	}

	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getid_product() {
		return id_product;
	}

	public void setid_product(String id_product) {
		this.id_product = id_product;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getid_producer() {
		return id_producer;
	}

	public void setid_producer(String id_producer) {
		this.id_producer = id_producer;
	}
	
	
	public String getId_producttype() {
		return id_producttype;
	}

	public void setId_producttype(String id_producttype) {
		this.id_producttype = id_producttype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	@Override
	public String toString() {
		return "product [id_product=" + id_product + ", nameProduct=" + nameProduct + ", price=" + price
				+ ", id_producer=" + id_producer + ", id_producttype=" + id_producttype + ", description=" + description
				+ ", url=" + url + ", nameSize=" + nameSize + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id_product, nameProduct, price, id_producer, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		product other = (product) obj;
		return Objects.equals(id_product, other.id_product);
	}
	
	
}
