package com.fragrance.web.commonservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Celeb;
import com.fragrance.web.entity.Items;

public class SearchServices {
	private int index = 0;

	public int getIndex() {
		return index;
	}

	public List<Items> getSearchItems(String query) throws SQLException, ClassNotFoundException {
		List<Items> list = new ArrayList<>();
		String sql = "select * from Items where name LIKE '%"+query+"%' || brand LIKE '%"+query+"%' || scent LIKE '%"+query+"%' || content LIKE '%"+query+"%' || tag LIKE '%?%' limit 3";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
					rs.getString("brand"), rs.getInt("size"), rs.getInt("price"), rs.getString("scent"),
					rs.getString("gender"), rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"),
					rs.getString("content"), rs.getString("tag"));

			index++;
			list.add(items);

		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	public List<Celeb> getSearchCeleb(String query) throws ClassNotFoundException, SQLException {
		List<Celeb> list = new ArrayList<>();
		String sql = "select * from Celeb where content LIKE '%"+query+"%' || title LIKE '%"+query+"%' || celeb LIKE '%"+query+"%' limit 3";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Celeb celeb = new Celeb(
					rs.getInt("titlenums"), 
					rs.getString("imgBanner"),
					rs.getString("imgDetail"),
					rs.getString("title"), 
					rs.getString("writerId"),
					rs.getString("regdate"),
					rs.getString("content"),
					rs.getInt("like"),
					rs.getInt("hit"),
					rs.getString("celeb"),
					rs.getInt("itemNums"));

			list.add(celeb);

		}
		rs.close();
		st.close();
		con.close();
		return list;
		
	}

}
