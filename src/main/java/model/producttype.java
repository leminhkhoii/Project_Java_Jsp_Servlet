package model;

import java.util.Objects;

public class producttype {
	String id_producttype;
	String nameProducttype;
	
	public producttype(String id_producttype, String nameProducttype) {
		this.id_producttype = id_producttype;
		this.nameProducttype = nameProducttype;
	}
	
	public producttype() {
	}

	public String getId_producttype() {
		return id_producttype;
	}

	public void setId_producttype(String id_producttype) {
		this.id_producttype = id_producttype;
	}

	public String getNameProducttype() {
		return nameProducttype;
	}

	public void setNameProducttype(String nameProducttype) {
		this.nameProducttype = nameProducttype;
	}

	@Override
	public String toString() {
		return "producttype [id_producttype=" + id_producttype + ", nameProducttype=" + nameProducttype + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_producttype, nameProducttype);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		producttype other = (producttype) obj;
		return Objects.equals(id_producttype, other.id_producttype)
				&& Objects.equals(nameProducttype, other.nameProducttype);
	}
	
	
}
