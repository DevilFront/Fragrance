package com.fragrance.web.controller.rank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet("/HTML/rank/rankIndex")
public class IndexCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
		
		RankServices service = new RankServices();
		List<Items> manslist = null;
		List<Items> womanlist = null;
		List<Items> solidlist = null;
		List<Items> rollonlist = null;
		List<Items> list = null;
		ArrayList<List<Items>> items = new ArrayList<List<Items>>();
		
		try {
			manslist = service.getManLikeList();
			womanlist = service.getWomanLikeList();
			solidlist = service.getSolidLikeList();
			rollonlist = service.getRollonLikeList();
			list = service.getUnisexLikeList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		items.add(manslist);
		items.add(womanlist);
		items.add(list);
		items.add(solidlist);
		items.add(rollonlist);

		request.setAttribute("items", items);
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("rank.rankIndex", request, response);
	}
}
