package com.fragrance.web.service.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Items;

public class AdminItemService {

	public Items getItem(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Items WHERE itemNums = ?";

		// String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		Items items = null;
		if (rs.next()) {
			items = new Items(rs.getInt("ItemNums"), rs.getString("img"), rs.getString("name"), rs.getString("brand"),
					rs.getInt("size"), rs.getInt("price"), rs.getString("scent"), rs.getString("gender"),
					rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"), rs.getString("content"),
					rs.getString("tag"));
		}

		rs.close();
		st.close();
		con.close();
		return items;
	}

	public List<Items> getItemsList(int page) throws SQLException, ClassNotFoundException {
		List<Items> list = new ArrayList<>();
		int index = 0;
		String sql = "select * from  Items limit 10 offset ?;";// WHERE NUM BETWEEN 1 AND 10";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, (page - 1) * 10);// 1->0 2->10

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Items items = new Items(rs.getInt("ItemNums"), rs.getString("img"), rs.getString("name"),
					rs.getString("brand"), rs.getInt("size"), rs.getInt("price"), rs.getString("scent"),
					rs.getString("gender"), rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"),
					rs.getString("content"), rs.getString("tag"));
			list.add(items);
		}

		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int insertItem(Items items) throws ClassNotFoundException, SQLException {

		int result = 0;
		String sql = "INSERT INTO Items(img, name, brand, size, price, scent, gender, type, content, tag) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, items.getImg());
		st.setString(2, items.getName());
		st.setString(3, items.getBrand());
		st.setInt(4, items.getSize());
		st.setInt(5, items.getPrice());
		st.setString(6, items.getScent());
		st.setString(7, items.getGender());
		st.setString(8, items.getType());
		st.setString(9, items.getContent());
		st.setString(10, items.getTag());
		result = st.executeUpdate();
		System.out.println(result);
		return result;

	}

	public int updateItems(Items items) throws ClassNotFoundException, SQLException {

		int result = 0;
		String sql = "UPDATE Items SET img = ? ,name = ? , brand=? ,size = ? , price = ? , scent=? ,gender=? ,type=? ,tag=? ,content = ? WHERE itemNums=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, items.getImg());
		st.setString(2, items.getName());
		st.setString(3, items.getBrand());
		st.setInt(4, items.getSize());
		st.setInt(5, items.getPrice());
		st.setString(6, items.getScent());
		st.setString(7, items.getGender());
		st.setString(8, items.getType());
		st.setString(9, items.getTag());
		st.setString(10, items.getContent());
		st.setInt(11, items.getItemnums());
		result = st.executeUpdate();

		return result;

	}

	public void deleteItem(int id) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "DELETE FROM Items WHERE itemNums=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		result = st.executeUpdate();

	}
	

	public int getItemsCount() throws ClassNotFoundException, SQLException {

		int count = 0;
		String sql = "select count(itemNums) count from Items";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		if (rs.next())
			count = rs.getInt("count");// TODO Auto-generated method stub
		return count;
	}

	public int delItemsAll(int[] ids) throws ClassNotFoundException, SQLException {
		int result = 0;
		String params = "";
		for (int i = 0; i < ids.length; i++) {
			params += ids[i];
			System.out.println(params);
			if (i < ids.length - 1)
				params += ",";
		}
		String sql = "DELETE FROM Items WHERE itemNums in (" + params + ")";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		result = st.executeUpdate();
		return result;

	}

}
