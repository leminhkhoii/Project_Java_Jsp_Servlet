package model;

import java.util.Objects;

public class producer {
	String id_producer;
	String nameProducer;
	
	public producer(String id_producer, String nameProducer) {
		this.id_producer = id_producer;
		this.nameProducer = nameProducer;
	}

	public producer() {
	}

	public String getId_producer() {
		return id_producer;
	}

	public void setId_producer(String id_producer) {
		this.id_producer = id_producer;
	}

	public String getNameProducer() {
		return nameProducer;
	}

	public void setNameProducer(String nameProducer) {
		this.nameProducer = nameProducer;
	}

	@Override
	public String toString() {
		return "producer [id_producer=" + id_producer + ", nameProducer=" + nameProducer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_producer, nameProducer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		producer other = (producer) obj;
		return Objects.equals(id_producer, other.id_producer) && Objects.equals(nameProducer, other.nameProducer);
	}
	
	
	
}
