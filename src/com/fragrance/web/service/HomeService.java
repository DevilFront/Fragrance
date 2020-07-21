package com.fragrance.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fragrance.web.entity.Items;

public class HomeService {
   
   public List<Items> getHomeMan() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "Select * from Items where gender = '남성' order by maleLike+femaleLike desc LIMIT 1;";
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

   public List<Items> getHomeWoman() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "Select * from Items where gender = '여성' order by maleLike+femaleLike desc LIMIT 1;";
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

   public List<Items> getHomeUni() throws SQLException, ClassNotFoundException {
      List<Items> list = new ArrayList<>();
      int index = 0;

      String sql = "Select * from Items where gender = '공용' order by maleLike+femaleLike desc LIMIT 1;";
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
   
   public List<Items> getHomeEtc() throws ClassNotFoundException, SQLException {
      // TODO Auto-generated method stub
      
      List<Items> list = new ArrayList<>();
      String sql = "select *from Items  where type = '롤온' or type='고체' order by maleLike+femaleLike desc LIMIT 1;";
      String url = "jdbc:mysql://dev.notepubs.com:9898/fragrance?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, "fragrance", "0505");
      PreparedStatement st = con.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      
      if(rs.next()) {
         Items items = new Items(rs.getInt("itemnums"), rs.getString("img"), rs.getString("name"),
               rs.getString("brand"), rs.getInt("size"), rs.getInt("price"), rs.getString("scent"),
               rs.getString("gender"), rs.getInt("maleLike"), rs.getInt("femaleLike"), rs.getString("type"),
               rs.getString("content"), rs.getString("tag"));
         list.add(items);
      };
      rs.close();
      st.close();
      con.close();
      return list;
   }

   public List<Items> getHomeSummer()
         throws ClassNotFoundException, SQLException {

      List<Items> list = new ArrayList<>();

      String sql = "select *from Items where tag like'%여름%' order by maleLike+femaleLike desc LIMIT 1;";
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
   
   public List<Items> getHomeCrab()
         throws ClassNotFoundException, SQLException {

      List<Items> list = new ArrayList<>();

      String sql = "select *from Items where tag like'%게자리%' order by maleLike+femaleLike desc LIMIT 1;";
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
   
   public List<Items> getHomeDaily()
         throws ClassNotFoundException, SQLException {

      List<Items> list = new ArrayList<>();

      String sql = "select *from Items where tag like'%데일리%' order by maleLike+femaleLike desc LIMIT 1;";
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
   
}