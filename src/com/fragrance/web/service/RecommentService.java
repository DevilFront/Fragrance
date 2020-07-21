package com.fragrance.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Items;
import com.fragrance.web.entity.Result;

public class RecommentService {

	public List<Items> getRecommentList(String colum, String tag) throws ClassNotFoundException, SQLException {

		List<Items> list = new ArrayList<>();

		String sql = "SELECT * FROM Items WHERE " + colum + " like ? limit 12";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, tag);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
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

	public List<Items> getResultList(String gender, String age, String season, String scent)
			throws ClassNotFoundException, SQLException {

		List<Items> list = new ArrayList<>();
		String tag1 = "%" + age + "%";
		String tag2 = "%" + season + "%";
		String tag3 = "%" + scent + "%";

		String sql = "SELECT * FROM (SELECT Items.* FROM Items where gender = ? or gender = '����') t where (t.tag like ? and t.tag like ? and t.tag like ?) limit 3";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, gender);
		st.setString(2, tag1);
		st.setString(3, tag2);
		st.setString(4, tag3);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
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
}
