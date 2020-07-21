package com.fragrance.web.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.fragrance.web.commonservice.SearchServices;
import com.fragrance.web.entity.Celeb;
import com.fragrance.web.entity.Items;

@WebServlet(urlPatterns = {"/HTML/search", "/HTML/rank/search","/HTML/celeb/search","/HTML/rec/search"})
public class SearchCtrl extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int index = 0;
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      String query = request.getParameter("query");
      
      if(query.equals("")) {
         PrintWriter out = response.getWriter();
         out.println("<script>alert('검색어를 입력하세요.'); location.href='/index';</script>");
         out.flush();
      }
      List<Items> itemlist = null;
      List<Celeb> celeblist = null;

      SearchServices service = new SearchServices();
      try {
         itemlist = service.getSearchItems(query);
         celeblist = service.getSearchCeleb(query);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      System.out.println(request.getRequestURI());
      request.setAttribute("item", itemlist);
      request.setAttribute("celeb", celeblist);

      TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
      container.render("rank.search", request, response);
   }
}