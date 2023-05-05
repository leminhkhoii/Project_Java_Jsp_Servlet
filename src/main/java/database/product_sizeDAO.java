package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.product;
import model.product_size;
import model.product_sizee;

public class product_sizeDAO {
	public product_sizee selectByIdProductAndIdSize(String id1, String id2)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product_size where id_product=? and id_size=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id1);
			st.setString(2, id2);
			
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
