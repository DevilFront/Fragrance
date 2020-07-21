package com.fragrance.web.commonservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Reply;
import com.mysql.cj.protocol.ServerSession;

public class CommentServices {

	public int regComment(Reply reply) throws SQLException, ClassNotFoundException {
		int result=0;
		String sql = "INSERT INTO reply(itemNums,writerName,content) VALUES(?,?,?);";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, reply.getItemNums());
		st.setString(2, reply.getWriterName() );
		st.setString(3, reply.getContent());
		
		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}
	
	public List<Reply> getComment(int id) throws SQLException, ClassNotFoundException {
		List<Reply> list = new ArrayList<>();
		int index = 0;
		String sql = "Select * from reply WHERE itemNums=?;";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Reply reply=new Reply(
					rs.getInt("id"), 
					rs.getInt("itemNums"),
					rs.getString("writerName"),
					rs.getString("content"),
					rs.getDate("regDate"));
			list.add(reply);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int deleteComment(int id) throws SQLException, ClassNotFoundException {
		int result=0;
		String sql = "DELETE FROM reply WHERE id=?;";
		String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "fragrance", "0505");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}


}
