package model;

import java.sql.Date;
import java.util.Objects;

public class order {
	private int id_order;
	private Date order_date;
	private Date delivery_date;
	private double total_money;
	private String status;
	private String id_customer;
	private String method;
	private String order_date1;
	private String delivery_date1;
	
	public order() {
	}

	public order(int id_order, Date order_date, Date delivery_date, double total_money, String status,
			String id_customer) {
		this.id_order = id_order;
		this.order_date = order_date;
		this.delivery_date = delivery_date;
		this.total_money = total_money;
		this.status = status;
		this.id_customer = id_customer;
	}
	
	public order(int id_order, Date order_date, Date delivery_date, double total_money, String status,
			String id_customer, String method) {
		super();
		this.id_order = id_order;
		this.order_date = order_date;
		this.delivery_date = delivery_date;
		this.total_money = total_money;
		this.status = status;
		this.id_customer = id_customer;
		this.method = method;
	}
	
	
	
	public order(int id_order, double total_money, String status, String id_customer, String method, String order_date1,
			String delivery_date1) {
		super();
		this.id_order = id_order;
		this.total_money = total_money;
		this.status = status;
		this.id_customer = id_customer;
		this.method = method;
		this.order_date1 = order_date1;
		this.delivery_date1 = delivery_date1;
	}

	
	
	public String getOrder_date1() {
		return order_date1;
	}

	public void setOrder_date1(String order_date1) {
		this.order_date1 = order_date1;
	}

	public String getDelivery_date1() {
		return delivery_date1;
	}

	public void setDelivery_date1(String delivery_date1) {
		this.delivery_date1 = delivery_date1;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	public double getTotal_money() {
		return total_money;
	}

	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId_customer() {
		return id_customer;
	}

	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	@Override
	public String toString() {
		return "order [id_order=" + id_order + ", order_date=" + order_date + ", delivery_date=" + delivery_date
				+ ", total_money=" + total_money + ", status=" + status + ", id_customer=" + id_customer + ", method="
				+ method + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(delivery_date, id_customer, id_order, order_date, status, total_money);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		order other = (order) obj;
		return Objects.equals(id_order, other.id_order) ;
	}
	
	
	
}
