package com.fragrance.web.service.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.User;

public class AdminUserService {
	public User getUser(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM User WHERE userNum = ?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User(rs.getInt("userNum"), rs.getString("mail"), rs.getString("pw"), rs.getString("nickName"),
					rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("role"));
		}

		rs.close();
		st.close();
		con.close();
		return user;
	}

	public List<User> getUserList(int page) throws SQLException, ClassNotFoundException {
		List<User> list = new ArrayList<>();
		int index = 0;
		String sql = "select * from  User limit 10 offset ?;";// WHERE NUM BETWEEN 1 AND 10";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, (page - 1) * 10);// 1->0 2->10

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			User users = new User(rs.getInt("userNum"), rs.getString("mail"), rs.getString("pw"),
					rs.getString("nickName"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"),
					rs.getString("role"));
			list.add(users);
		}

		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int getUserCount() throws ClassNotFoundException, SQLException {

		int count = 0;
		String sql = "select count(userNum) count from User";
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

	public int delUserAll(int[] ids) throws ClassNotFoundException, SQLException {
		int result = 0;
		String params = "";
		for (int i = 0; i < ids.length; i++) {
			params += ids[i];
			System.out.println(params + 1);
			if (i < ids.length - 1)
				params += ",";
		}
		String sql = "DELETE FROM User WHERE userNum in (" + params + ")";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		result = st.executeUpdate();
		return result;

	}

	public int updateUser(User user) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE User SET mail=?, pw=?, nickName=?, name=?, age=?, gender=?, role=? WHERE userNum=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, user.getMail());

		st.setString(2, user.getPw());
		st.setString(3, user.getNickName());
		st.setString(4, user.getName());
		st.setInt(5, user.getAge());
		st.setString(6, user.getGender());
		st.setString(7, user.getRole());
		st.setInt(8, user.getUserNum());
		System.out.println(user.getUserNum());

		result = st.executeUpdate();

		return result;

	}

}
