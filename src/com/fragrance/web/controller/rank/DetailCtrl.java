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

import com.fragrance.web.commonservice.CommentServices;
import com.fragrance.web.entity.Items;
import com.fragrance.web.entity.Reply;
import com.fragrance.web.service.RankServices;

@WebServlet("/HTML/rank/detail")
public class DetailCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int itemnums = Integer.parseInt(request.getParameter("id"));

		List<Items> list = null;
		List<Reply> commentList = null;
		RankServices services = new RankServices();
		CommentServices cServices= new CommentServices();
		try {
			list = services.getItemDetail(itemnums);
			commentList=cServices.getComment(itemnums);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", list);
		request.setAttribute("comment", commentList);
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("rank.detail", request, response);
	}
}
