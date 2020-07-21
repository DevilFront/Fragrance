package com.fragrance.web.controller.celeb;

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

import com.fragrance.web.entity.Celeb;
import com.fragrance.web.service.CelebService;

@WebServlet("/HTML/celeb/celeb")
public class CelebController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");
		CelebService service = new CelebService();
		
		List<Celeb> celeb = null;
		
		try {
			celeb = service.getCelebList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("c", celeb);
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("celeb.celeb", request, response);
	}
}
