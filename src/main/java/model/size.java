package model;

import java.util.Objects;

public class size {
	private String id_size;
	private String nameSize;
	
	public size(String id_size, String nameSize) {
		this.id_size = id_size;
		this.nameSize = nameSize;
	}

	public size() {
	}

	public String getId_size() {
		return id_size;
	}

	public void setId_size(String id_size) {
		this.id_size = id_size;
	}

	public String getNameSize() {
		return nameSize;
	}

	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}

	@Override
	public String toString() {
		return "size [id_size=" + id_size + ", nameSize=" + nameSize + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_size, nameSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		size other = (size) obj;
		return Objects.equals(id_size, other.id_size) && Objects.equals(nameSize, other.nameSize);
	}
}
