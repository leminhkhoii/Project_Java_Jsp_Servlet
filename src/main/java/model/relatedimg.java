package model;

import java.util.Objects;

public class relatedimg {
	private String id_img;
	private String id_product;
	private String url;
	
	public relatedimg() {
	}

	public relatedimg(String id_img, String id_product, String url) {
		this.id_img = id_img;
		this.id_product = id_product;
		this.url = url;
	}

	public String getId_img() {
		return id_img;
	}

	public void setId_img(String id_img) {
		this.id_img = id_img;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "relatedimg [id_img=" + id_img + ", id_product=" + id_product + ", url=" + url + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_img, id_product, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		relatedimg other = (relatedimg) obj;
		return Objects.equals(id_img, other.id_img);
				
	}
	
	
}
