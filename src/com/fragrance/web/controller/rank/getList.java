package com.fragrance.web.controller.rank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.fragrance.web.entity.Items;
import com.fragrance.web.service.RankServices;

@WebServlet("/HTML/rank/list")
public class getList extends HttpServlet {

	  @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
	      request.setCharacterEncoding("UTF-8");
	      int count = 0;
	      int page = 1;

	      if (request.getParameter("p") != null && !request.getParameter("p").equals("")) {
	         String page_ = request.getParameter("p");
	         page = Integer.parseInt(page_);
	      }
	      RankServices service = new RankServices();
	      List<Items> list = null;
	      String get = request.getParameter("c");
	      try {

	         if (get.equals("m")) {
	            list = service.getManItems(page);
	            count = service.getCount("남성", null);
	         }
	         else if (get.equals("w")) {
	            list = service.getWomenItems(page);
	            count = service.getCount("여성", null);

	         }
	         else if (get.equals("u")) {
	            list = service.getUnisexItems(page);
	            count = service.getCount("공용", null);
	         }

	         else if (get.equals("s")) {
	            list = service.getSolidItems(page);
	            count = service.getCount(null, "고체");
	         }
	         else if (get.equals("r")) {
	            list = service.getRollItems(page);
	            count = service.getCount(null, "롤온");
	         }
	         else {
	             list = service.getSearchDetail(page,get);
	             count = service.getSearchItemsCount(get);
	          }
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	      int index = ((int) (count / 10) + 1);
	      request.setAttribute("list", list);
	      request.setAttribute("index", index);

	      TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
	      container.render("rank.list", request, response);
	   }
	}