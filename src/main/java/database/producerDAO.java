package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.producer;
import model.product;

public class producerDAO implements DAOInteface<producer> {

	@Override
	public ArrayList<producer> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public producer selectById(producer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public producer selectByIdProducer(String t) {
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM producer where id_producer=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new producer(rs.getString(1), rs.getString(3));
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
	public int insert(producer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<producer> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(producer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<producer> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(producer t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
