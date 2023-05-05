package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.product;
import model.relatedimg;

public class relatedimgDAO implements DAOInteface<relatedimg>{

	@Override
	public ArrayList<relatedimg> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<relatedimg> getAllImg(String id)
	{
		List<relatedimg> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM related_image where id_product=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new relatedimg(rs.getString(1),rs.getString(2),rs.getString(3)));
				
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
	public relatedimg selectById(relatedimg t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(relatedimg t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<relatedimg> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(relatedimg t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<relatedimg> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(relatedimg t) {
		// TODO Auto-generated method stub
		return 0;
	}
public static void main(String[] args) {
	relatedimgDAO rD = new relatedimgDAO();
	List<relatedimg> list = new ArrayList<>();
	list = rD.getAllImg("001");
	System.out.println(list);
}
}
