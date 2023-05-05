package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.customer;
import model.product;

public class customerDAO implements DAOInteface<customer> {

	@Override
	public ArrayList<customer> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public customer selectById(customer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<customer> getAllCustomer(){
		List<customer> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new customer(rs.getString(1), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(3)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<customer> getAllCustomerWithStatus(){
		List<customer> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new customer(rs.getString(1), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(3), rs.getInt(10)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public customer selectById(int id) {
		customer result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE id_customer=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String id_customer = rs.getString("id_customer");
				String accountname = rs.getString("accountname");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");

				result = new customer(id_customer, name, address, accountname, password, phone, email, gender);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public customer selectByIdWithStatus(int id) {
		customer result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE id_customer=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String id_customer = rs.getString("id_customer");
				String accountname = rs.getString("accountname");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				int status = rs.getInt("status");
				
				result = new customer(id_customer, name, address, accountname, password, phone, email, gender, status);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public customer selectByUsernameAndPassWord(customer t) {
		customer result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE accountname=? and password=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(t.getAccountName()+"/"+t.getPassWord());
			st.setString(1, t.getAccountName());
			st.setString(2, t.getPassWord());
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String id_customer = rs.getString("id_customer");
				String accountname = rs.getString("accountname");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				int status = rs.getInt("status");


				result = new customer(id_customer, name, address, accountname, password, phone, email, gender, status);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	
	public List<customer> getUSerBySearchName(String name){
		List<customer> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE accountname LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new customer(rs.getString(1), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(3)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insert(customer t) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			// Bước 1: Tạo kết nối với cơ sở dữ liệu
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO customer (id_customer, gender, name, address, accountname, password, phone, email)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getid_customer());
			st.setString(2, t.getGender());
			st.setString(3, t.getName());
			st.setString(4, t.getAddress());
			st.setString(5, t.getAccountName());
			st.setString(6, t.getPassWord());
			st.setString(7, t.getPhone());
			st.setString(8, t.getEmail());
			
			// Bước 3: Thực thi câu lệnh sql
			result=st.executeUpdate();
			
			// Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + result + " dòng bị thay đổi!");
			
			// Bước 5: Đóng kết nối
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public customer selectTopCustomer()
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "Select id_customer from customer order by id_customer DESC LIMIT 1";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new customer(rs.getString(1), "", "", "", "", "", "", "");
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkAccountName(String accountName)
	{
		boolean result = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE accountname=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, accountName);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				result= true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
	}

	@Override
	public int insertAll(ArrayList<customer> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<customer> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(customer t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET " + " gender=?" + ", name=?" + ", address=?" 
					 + ", phone=?" + ", email=?" + ", phone=?" + ", password=?"
					+ " WHERE accountname=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getGender());
			st.setString(2, t.getName());
			st.setString(3, t.getAddress());
			st.setString(4, t.getPhone());
			st.setString(5, t.getEmail());
			st.setString(6, t.getPhone());
			st.setString(7, t.getPassWord());
			st.setString(8, t.getAccountName());
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
	
	public boolean changePassWord(customer t)
	{
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET "  + " password=?" + " WHERE id_customer=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getPassWord());
			st.setString(2, t.getid_customer());
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
		return result>0;
	}
	
	public boolean updateStatus(customer t)
	{
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET "  + " status=?" + " WHERE id_customer=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getStatus());
			st.setString(2, t.getid_customer());
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
		return result>0;
	}
	
	public static void main(String[] args) {
		customerDAO cD = new customerDAO();
		customer c1 = new customer("1", "Le Minh Khoi", "CuChi", "minhkhoi872", "123", "0932167117", "leminhkhoi.cuchi@gmail.com", "nam");
		cD.insert(c1);
		//cD.selectByUsernameAndPassWord(c1);
		//cD.selectByUsernameAndPassWord(c1);
		customer c2 = cD.selectById(1);
		System.out.println(c2);
	}
	
}
