package com.fragrance.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Celeb;

public class CelebService {

	public List<Celeb> getCelebList() throws ClassNotFoundException, SQLException {

		List<Celeb> list = new ArrayList<>();

		String sql = "SELECT * FROM Celeb";
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

	public Celeb getCelebdetail(int id) throws ClassNotFoundException, SQLException {

		String sql = "Select * from Celeb  where titleNums =?;";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Celeb celeb = null;
		
		int result = 0;
	      String sql1 = "update Celeb set hit = hit+1 where titleNums=?";
	      PreparedStatement st1 = con.prepareStatement(sql1);
	      st1.setInt(1, id);
	      result = st1.executeUpdate();
		
		
		if (rs.next()) {
			celeb = new Celeb(
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
		}
		rs.close();
		st.close();
		con.close();
		return celeb;
	}

}