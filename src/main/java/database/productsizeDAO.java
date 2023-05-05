package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.product;
import model.product_sizee;

public class productsizeDAO  implements DAOInteface<product_sizee>{

	@Override
	public ArrayList<product_sizee> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public product_sizee selectById(product_sizee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(product_sizee t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<product_sizee> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(product_sizee t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<product_sizee> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(product_sizee t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int insertproduct_size(product_sizee p)
	{
		int result=0;
		try {
			// Bước 1: Tạo kết nối với cơ sở dữ liệu
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO product_size (id_product, id_size, quantity)"
					+ " VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p.getId_product());
			st.setString(2, p.getId_size());
			st.setInt(3, p.getQuantity());
			
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
	
	public product_sizee selectByIdProductAndIdSize(String id_p, String id_s)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product_size where id_product=? and id_size=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id_p);
			st.setString(2, id_s);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new product_sizee(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
