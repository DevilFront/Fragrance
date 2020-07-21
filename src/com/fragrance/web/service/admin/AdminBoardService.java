package com.fragrance.web.service.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Celeb;

public class AdminBoardService {

	public Celeb getBoard(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Celeb WHERE titleNums = ?";

		// String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		Celeb celeb = null;
		if (rs.next()) {
			celeb = new Celeb(rs.getInt("titleNums"), rs.getString("imgbanner"), rs.getString("imgDetail"),
					rs.getString("title"), rs.getString("writerId"), rs.getString("regdate"), rs.getString("content"),
					rs.getInt("like"), rs.getInt("hit"), rs.getString("celeb"), rs.getInt("itemNums"));
		}

		rs.close();
		st.close();
		con.close();
		return celeb;
	}

	public List<Celeb> getBoardList(int page) throws SQLException, ClassNotFoundException {
		List<Celeb> list = new ArrayList<>();
		int index = 0;
		String sql = "select * from  Celeb limit 10 offset ?;";// WHERE NUM BETWEEN 1 AND 10";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, (page - 1) * 10);// 1->0 2->10

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Celeb celeb = new Celeb(rs.getInt("titleNums"), rs.getString("imgbanner"), rs.getString("imgDetail"),
					rs.getString("title"), rs.getString("writerId"), rs.getString("regdate"), rs.getString("content"),
					rs.getInt("like"), rs.getInt("hit"), rs.getString("celeb"), rs.getInt("itemNums"));
			list.add(celeb);
		}

		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int insertBoard(Celeb celeb) throws ClassNotFoundException, SQLException {

		int result = 0;

		String sql = "INSERT INTO Items(img, name, brand, size, price, scent, gender, type, content, tag) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, celeb.getWriterId());
		st.setString(2, celeb.getRegDate());
		st.setString(3, celeb.getTitle());
		st.setString(4, celeb.getContent());
		st.setString(5, celeb.getImgBanner());
		st.setString(6, celeb.getImgDetail());
		st.setInt(7, celeb.getLike());
		st.setInt(8, celeb.getHit());
		st.setString(9, celeb.getCeleb());
		st.setInt(10, celeb.getItemNums());
		result = st.executeUpdate();
		System.out.println(result);
		return result;

	}

	public int updateBoard(Celeb celeb) throws ClassNotFoundException, SQLException {

		int result = 0;

		String sql = "UPDATE Items SET img =?, name=?, brand=?, size=?, scent=?, price=?, gender=?, type=?, content=?, tag=? WHERE itemNums=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, celeb.getWriterId());
		st.setString(2, celeb.getRegDate());
		st.setString(3, celeb.getTitle());
		st.setString(4, celeb.getContent());
		st.setString(5, celeb.getImgBanner());
		st.setString(6, celeb.getImgDetail());
		st.setInt(7, celeb.getLike());
		st.setInt(8, celeb.getHit());
		st.setString(9, celeb.getCeleb());
		st.setInt(10, celeb.getItemNums());

		result = st.executeUpdate();

		return result;

	}

	public void deleteBoard(int id) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "DELETE FROM Items WHERE itemNums=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		result = st.executeUpdate();
	}

	public int getCount() throws ClassNotFoundException, SQLException {

		int count = 0;
		String sql = "select count(titleNums) count from Celeb";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		if (rs.next())
			count = rs.getInt("count");// TODO Auto-generated method stub
		return count;
	}

	public int delBoardAll(int[] ids) throws ClassNotFoundException, SQLException {
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
