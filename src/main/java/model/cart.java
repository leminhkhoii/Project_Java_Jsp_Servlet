package model;

import java.util.ArrayList;
import java.util.List;

public class cart {
	private List<item> items;
	
	public cart() {
		items= new ArrayList<>();
	}
	
	public cart(List<item> items) {
		this.items=items;
	}
	
	public List<item> getItems() {
		return items;
	}

	public void setItems(List<item> items) {
		this.items = items;
	}

	public item getItemById(String id)
	{
		for (item item : items) {
			if(item.getProduct().getid_product().equals(id))
				return item;
		}
		return null;
	}
	
	public int getQuantityById(String id)
	{
		return getItemById(id).getQuantity();
	}
	
	// Thêm vào cart
	public void addItem(item t)
	{
		// Có cart roi
		if(this.getItemById(t.getProduct().getid_product())!=null)
		{
			item n = getItemById(t.getProduct().getid_product());
			n.setQuantity(n.getQuantity()+t.getQuantity());
			
		}else
		{
			// Chưa có trong cart
			items.add(t);
		}
	}
	
	// Xóa sản phẩm trong cart
	public void removeItem(String id)
	{
		if(this.getItemById(id)!=null)
		{
			items.remove(getItemById(id));
		}
	}
	
	// Lấy tổng tiền trong giỏ hàng
	public double getTotalMoney()
	{
		double t=0;
		for (item item : items) {
			t+=item.getQuantity()*item.getPrice();
		}
		return t;
	}
}
