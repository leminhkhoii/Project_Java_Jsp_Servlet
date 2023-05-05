package model;

import java.util.Objects;

public class customer {
	private String id_customer;
	private String name;
	private String address;
	private String accountName;
	private String passWord;
	private String phone;
	private String email;
	private String gender;
	private int status;
	
	public customer(String id_customer, String name, String address, String accountName, String passWord, String phone,
			String email, String gender) {
		this.id_customer = id_customer;
		this.name = name;
		this.address = address;
		this.accountName = accountName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}
	
	public customer(String id_customer, String name, String address, String accountName, String passWord, String phone,
			String email, String gender, int status) {
		super();
		this.id_customer = id_customer;
		this.name = name;
		this.address = address;
		this.accountName = accountName;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}




	public customer() {
	}

	
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getid_customer() {
		return id_customer;
	}

	public void setid_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountName, address, email, gender, id_customer, name, passWord, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		customer other = (customer) obj;
		return Objects.equals(id_customer, other.id_customer);
	}



	@Override
	public String toString() {
		return "customer [id_customer=" + id_customer + ", name=" + name + ", address=" + address + ", accountName="
				+ accountName + ", passWord=" + passWord + ", phone=" + phone + ", email=" + email + ", gender="
				+ gender + "]";
	}
	
	
}
