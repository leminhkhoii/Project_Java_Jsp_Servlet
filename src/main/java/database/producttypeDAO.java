package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.product;
import model.producttype;

public class producttypeDAO implements DAOInteface<producttype>{

	@Override
	public ArrayList<producttype> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public producttype selectById(producttype t) {
		// TODO Auto-generated method stub
		return null;
	}

	public producttype selectByIdProducttype(String id)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM producttype where id_producttype=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new producttype(rs.getString(1), rs.getString(3));
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insert(producttype t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<producttype> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(producttype t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<producttype> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(producttype t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
