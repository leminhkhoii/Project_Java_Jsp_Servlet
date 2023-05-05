 package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.cart;
import model.customer;
import model.item;
import model.order;
import model.product;
import model.product_size;
import model.product_sizee;
import model.relatedimg;
import model.size;

public class orderDAO {
	public void addOrder(customer u, cart c, String method)
	{
		LocalDate curDate = java.time.LocalDate.now();
		
		String date = curDate.toString();
		String date1 = curDate.plusDays(3).toString();
		try {
			// Bước 1: Tạo kết nối với cơ sở dữ liệu
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			String sql = "insert into order1 (order_date, total_money, id_customer, method_payment, delivery_date) VALUES (?,?,?,?,?)";	
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, date);
			st.setDouble(2, c.getTotalMoney());
			st.setString(3, u.getid_customer());
			st.setString(4, method);
			st.setString(5, date1);
			// Bước 3: Thực thi câu lệnh sql
			st.executeUpdate();
			System.out.println("Bạn đã thực thi: " + sql);
			// Lấy id của order vừa add
			String sql1 = "Select id_order from order1 order by id_order DESC LIMIT 1";
			PreparedStatement st1 = con.prepareStatement(sql1);
			ResultSet rs = st1.executeQuery();
			System.out.println("Bạn đã thực thi: " + sql1);
			// add vào bảng orderline 
			if(rs.next()) {
				int oid = rs.getInt(1);
				for(item i:c.getItems())
				{
					String sql2 = "Insert into order_line (id_order, id_product, quantity, price, size)"+
							" values (?,?,?,?,?)";
					PreparedStatement st2 = con.prepareStatement(sql2);
					st2.setInt(1, oid);
					st2.setString(2, i.getProduct().getid_product());
					st2.setInt(3, i.getQuantity());
					st2.setDouble(4, i.getPrice());
					st2.setString(5, i.getPz().getId_size());
					st2.executeUpdate();
				}
				for(item i:c.getItems())
				{
					productsizeDAO pzD = new productsizeDAO();
					product_sizee pze = pzD.selectByIdProductAndIdSize(i.getProduct().getId_product(), i.getPz().getId_size());
					int quantity = pze.getQuantity()-i.getQuantity();
					String sql3 = "UPDATE product_size " + " SET " + " quantity=?" 
								+ " where id_product=? and id_size=?";
					
					PreparedStatement st3 = con.prepareStatement(sql3);
					st3.setInt(1, quantity);
					st3.setString(2, i.getProduct().getid_product());
					st3.setString(3, i.getPz().getId_size());
					
					st3.executeUpdate();
				}
			}
			
			// Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			
			// Bước 5: Đóng kết nối
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public  List<order> selectByIdCustomer(customer t) {
		List<order> result = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 WHERE id_customer=? and status=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getid_customer());
			st.setString(2, "Shipping");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id_order = rs.getInt("id_order");
				Date order_date = rs.getDate("order_date");
				Date delivery_date = rs.getDate("delivery_date");
				Double total_money = rs.getDouble("total_money");
				String status = rs.getString("status");
				String id_customer = rs.getString("id_customer");
				String method_payment = rs.getString("method_payment");

				result.add( new order(id_order, order_date, delivery_date, total_money, status, id_customer, method_payment));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public  List<order> selectByIdCustomer1(customer t) {
		List<order> result = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 WHERE id_customer=? and status!=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getid_customer());
			st.setString(2, "Shipping");
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id_order = rs.getInt("id_order");
				Date order_date = rs.getDate("order_date");
				Date delivery_date = rs.getDate("delivery_date");
				Double total_money = rs.getDouble("total_money");
				String status = rs.getString("status");
				String id_customer = rs.getString("id_customer");
				String method_payment = rs.getString("method_payment");

				result.add( new order(id_order, order_date, delivery_date, total_money, status, id_customer, method_payment));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	
	public List<order> getAllOrder(){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1";
			PreparedStatement st = con.prepareStatement(sql);
			
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getString(7)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<order> getAllOrderByDate(String date){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 where delivery_date = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, date);
			
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getString(7)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public order selectByIdOrder(int id)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 where id_order=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateorder(order t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE order1 " + " SET " + " order_date=?" 
					 + ", delivery_date=?" + ", total_money=?" + ", status=?" + ", id_customer=?" + ", method_payment=?"
					+ " where id_order=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder_date1());
			st.setString(2, t.getDelivery_date1());
			st.setDouble(3, t.getTotal_money());
			st.setString(4, t.getStatus());
			st.setString(5, t.getId_customer());
			st.setString(6, t.getMethod());
			st.setInt(7, t.getId_order());
			
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public List<order> getUSerByProvince(String province){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer C, order1 O WHERE C.id_customer = O.id_customer AND C.address LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+province+"%");
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(10), rs.getDate(11), rs.getDate(12), rs.getDouble(13), rs.getString(14), rs.getString(15), rs.getString(16)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<order> getUSerByShipping(){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 WHERE STATUS = 'shipping'";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<order> getUSerByDelivered(){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 WHERE STATUS = 'delivered'";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<order> getUSerByCanceled(){
		List<order> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM order1 WHERE STATUS = 'canceled'";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new order(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		customer c = new customer("001", null, null, null, null, null, null, null);
		product p = new product("001", null, 0, null, null, null); 
		size s = new size("001", "S");
		product_sizee pz = new product_sizee(p.getid_product(), s.getId_size(), 0);
		List<item> list = new ArrayList<>();
		item i = new item(p, 0, 0, pz);
		list.add(i);
		cart cart = new cart(list);
		orderDAO oD = new orderDAO();
		//System.out.println(oD.selectByIdCustomer(c));
		//oD.addOrder(c, cart);
		//LocalDate curDate = java.time.LocalDate.now();
		
		//System.out.println(curDate.plusDays(3));
		System.out.println(oD.selectByIdOrder(5));
	}
}
