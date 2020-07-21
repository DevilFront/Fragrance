package com.fragrance.web.controller.home;

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
import com.fragrance.web.service.HomeService;
import com.fragrance.web.service.RecommentService;

@WebServlet("/index")
public class HomeController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HomeService service = new HomeService();
		List<Items> manslist = null;
		List<Items> womanlist = null;
		List<Items> unisexlist = null;
		List<Items> etclist = null;
		List<Items> summeritem = null;
		List<Items> crabitem = null;
		List<Items> dailyitem = null;
		

		try {
			manslist = service.getHomeMan();
			womanlist = service.getHomeWoman();
			unisexlist = service.getHomeUni();
			etclist = service.getHomeEtc();
			summeritem = service.getHomeSummer();
			crabitem = service.getHomeCrab();
			dailyitem = service.getHomeDaily();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("men", manslist);
		request.setAttribute("women", womanlist);
		request.setAttribute("unisex", unisexlist);
		request.setAttribute("etc", etclist);
		request.setAttribute("summer", summeritem);
		request.setAttribute("crab", crabitem);
		request.setAttribute("daily", dailyitem);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("home.index", request, response);
	}

}
