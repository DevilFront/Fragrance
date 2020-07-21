package com.fragrance.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Items;

public class RankServices {

   public List<Items> getManLikeList() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;
      String sql = "Select * from Items where gender='남성' order by maleLike desc LIMIT 3;";
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
         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getWomanLikeList() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "Select * from Items where gender='여성' order by femaleLike desc LIMIT 3;";
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
         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getUnisexLikeList() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT *,maleLike+femaleLike as Likeresult FROM Items where gender='공용' order by Likeresult DESC LIMIT 3";
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
         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getManItems(int page) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where gender='남성') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
         Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
               rs.getString("brand"), rs.getInt("size"), rs.getInt("price"), rs.getString("scent"),
               rs.getString("gender"), rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"),
               rs.getString("content"), rs.getString("tag"));
         index = rs.getInt("num");

         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getWomenItems(int page) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where gender='여성') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
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

   public List<Items> getUnisexItems(int page) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where gender='공용') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
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

   public List<Items> getSolidItems(int page) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where type='고체') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
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

   public List<Items> getRollItems(int page) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where type='롤온') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
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

   public List<Items> getSearchDetail(int page, String query) throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;
      System.out.println("before query");
      String sql = "SELECT m.* from(SELECT @rownum:=@rownum+1 num, I.* FROM Items I, (SELECT @rownum:=0) TMP where name LIKE '%"+query+"%' || brand LIKE '%"+query+"%' || scent LIKE '%"+query+"%' || content LIKE '%"+query+"%' || tag LIKE '%s"+query+"%') m limit 10 offset ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, (page - 1) * 10); // 1
      ResultSet rs = st.executeQuery();
      System.out.println("after query");
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

   public List<Items> getItemDetail(int itemnums) throws ClassNotFoundException, SQLException {
      // TODO Auto-generated method stub

      List<Items> list = new ArrayList<>();
      String sql = "Select * from Items where itemnums = ?;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, itemnums);
      ResultSet rs = st.executeQuery();

      if (rs.next()) {
         Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
               rs.getString("brand"), rs.getInt("size"), rs.getInt("price"), rs.getString("scent"),
               rs.getString("gender"), rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"),
               rs.getString("content"), rs.getString("tag"));
         list.add(items);
      }
      ;
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getSolidLikeList() throws ClassNotFoundException, SQLException {
      List<Items> list = new ArrayList<>();
      int index = 0;
      String sql = "select *from Items where type='고체' order by maleLike+femaleLike desc;";
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
         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getRollonLikeList() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;
      String sql = "select *from Items where type='롤온' order by maleLike+femaleLike desc;";
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
         list.add(items);
      }
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public int getCount(String c, String type) throws ClassNotFoundException, SQLException {
      int index = 0;
      String sql = "select count(itemNums) nums from Items where gender ='" + c + "' || type='" + type + "';";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
//         st.setInt(1, (page-1)*5);
      while (rs.next()) {
         index = rs.getInt("nums");
      }
      rs.close();
      st.close();
      con.close();

      return index;
   }

   public int getSearchItemsCount(String query) throws SQLException, ClassNotFoundException {
      int index = 0;
      String sql = "select count(itemNums) nums from Items where name LIKE '%" + query + "%' || brand LIKE '%" + query
            + "%' || scent LIKE '%" + query + "%' || content LIKE '%" + query + "%' || tag LIKE '%?%'";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);

      ResultSet rs = st.executeQuery();
      while (rs.next()) {
         index = rs.getInt("nums");
      }
      rs.close();
      st.close();
      con.close();

      return index;
   }
}