package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.customer;
import model.product;

public class productDAO implements DAOInteface<product> {

	@Override
	public ArrayList<product> selectALl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<product> getAllProduct(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = con.prepareStatement(sql);
			
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductWithSize(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product P , product_size PZ, size S WHERE P.id_product=PZ.id_product AND PZ.id_size=S.id_size";
			PreparedStatement st = con.prepareStatement(sql);
			
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(13), rs.getInt(11)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<product> getAllProductByShirt(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'A01'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByHoodie(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'A02'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductBySweater(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'A03'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByCardigan(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'A04'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByJacket(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'A05'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByPant(){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE id_producttype = 'Q01'";
			PreparedStatement st = con.prepareStatement(sql);
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByFilter1(String txt){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product P , product_size PZ, size S WHERE P.id_product=PZ.id_product AND PZ.id_size=S.id_size and price > 100000 AND price < 300000 and nameproduct like?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+txt+"%");
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(13), rs.getInt(11)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getAllProductByFilter2(String txt){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product P , product_size PZ, size S WHERE P.id_product=PZ.id_product AND PZ.id_size=S.id_size and price > 200000 AND price < 500000 and nameproduct like?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+txt+"%");
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(13), rs.getInt(11)));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<product> getProductBySearchName(String name){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE nameproduct LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getProductBySearchNameDividePage(String txtSearch, int index, int size){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "WITH x as(SELECT *, ROW_NUMBER() OVER (order BY id) AS row_num FROM product	WHERE nameproduct LIKE ?)\r\n"
					+ "SELECT * FROM x WHERE row_num BETWEEN ?*3-2 AND ?*3";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+txtSearch+"%");
			st.setInt(2, index);
			st.setInt(3, index);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<product> getProductBySearchNameDividePage1(String txtSearch, int index, int size){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "WITH x as(SELECT *, ROW_NUMBER() OVER (order BY id) AS row_num FROM product	WHERE nameproduct LIKE ? AND price>=200000 AND price<=300000)\r\n"
					+ "SELECT * FROM x WHERE row_num BETWEEN ?*3-2 AND ?*3";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+txtSearch+"%");
			st.setInt(2, index);
			st.setInt(3, index);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int getCountProductBySearchName(String name){
		int i=0;
		try {
			
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT count(*) FROM product WHERE nameproduct LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while(rs.next())
			{
				return rs.getInt(1);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<product> getProductByAZName(String name){
		List<product> list = new ArrayList<>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE nameproduct LIKE ? order BY nameproduct ASC";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+name+"%");
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				list.add(new product(rs.getString(1),rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
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
	public product selectById(product t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public product selectByIdProduct(String id)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product where id_product=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new product(rs.getString(1), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public product selectTopProduct()
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "Select id_product from product order by id_product DESC LIMIT 1";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return new product(rs.getString(1), "", 0.0, "", "", "", "");
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public int insert1(product t, String id_size, int quantity) {
		// TODO Auto-generated method stub
				int result=0;
				try {
					// Bước 1: Tạo kết nối với cơ sở dữ liệu
					Connection con = JDBCUtil.getConnection();
					
					// Bước 2: Tạo ra đối tượng statement
					String sql = "INSERT INTO product (id_product, nameproduct, price, id_producer, id_producttype, description, url)"
							+ " VALUES (?,?,?,?,?,?,?)";
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, t.getid_product());
					st.setString(2, t.getNameProduct());
					st.setDouble(3, t.getPrice());
					st.setString(4, t.getid_producer());
					st.setString(5, t.getId_producttype());
					st.setString(6, t.getDescription());
					st.setString(7, t.getUrl());
					
					// Bước 3: Thực thi câu lệnh sql
					result=st.executeUpdate();
					
					// Bước 4: 
					System.out.println("Bạn đã thực thi: " + sql);
					System.out.println("Có " + result + " dòng bị thay đổi!");
					
					String sql2 ="INSERT INTO product_size (id_product,id_size,quantity) VALUES (?,?,?)";
					PreparedStatement st1 = con.prepareStatement(sql2);
					st1.setString(1, t.getId_product());
					st1.setString(2, id_size);
					st1.setInt(3, quantity);
					
					result=st1.executeUpdate();
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

	@Override
	public int insertAll(ArrayList<product> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<product> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(product t) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product " + " SET " + " url=?" + ", nameproduct=?" + ", price=?" 
					 + ", id_producer=?" + ", id_producttype=?" + ", description=?"
					+ " where id_product=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUrl());
			st.setString(2, t.getNameProduct());
			st.setDouble(3, t.getPrice());
			st.setString(4, t.getid_producer());
			st.setString(5, t.getId_producttype());
			st.setString(6, t.getDescription());
			st.setString(7, t.getid_product());
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
	
	public int updatewithoutimg(product t, String id_size, int quantity) {
		int result = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product " + " SET " + " nameproduct=?" + ", price=?" 
					 + ", id_producer=?" + ", id_producttype=?" + ", description=?" 
					+ " where id_product=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameProduct());
			st.setDouble(2, t.getPrice());
			st.setString(3, t.getid_producer());
			st.setString(4, t.getId_producttype());
			st.setString(5, t.getDescription());
			st.setString(6, t.getid_product());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			result = st.executeUpdate();
			
			String sql1 = "UPDATE product_size " + " SET " + " quantity=?"  
					+ " where id_product=? and id_size=?";
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.setInt(1, quantity);
			st1.setString(2, t.getid_product());
			st1.setString(3, id_size);
			
			System.out.println(sql1);
			result = st1.executeUpdate();
			
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
	
	public void deleteProduct (String id)
	{
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "delete from product where id_product=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			st.executeUpdate();
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) {
	productDAO pD = new productDAO();
	List<product> list = pD.getAllProductWithSize();
	//System.out.println(list);
	//product p = pD.selectTopProduct();
	//System.out.println(list);
	System.out.println(pD.getProductBySearchNameDividePage("leve", 1, 3));
}

@Override
public int insert(product t) {
	// TODO Auto-generated method stub
	return 0;
}
}
