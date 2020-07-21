package com.fragrance.web.controller.recommend;

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
import com.fragrance.web.service.RecommentService;

//다른 쪽에서 list 컨트롤러를 만들면 코드만 대체하고 애노테이션으로 맵핑해주면된다.
@WebServlet("/HTML/rec/recomm")
public class RecommentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		RecommentService service = new RecommentService();
		List<Items> list = null;
		

		String colum = "''";
		String tag = "";
		
		if(request.getParameter("tag")!=null&&
				!request.getParameter("tag").equals("")) {
		colum = "tag";
		tag = "%" + request.getParameter("tag") + "%";
		}

		try {
			list = service.getRecommentList(colum,tag);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("recommend", list);
//		request.getRequestDispatcher("/HTML/rec/recomm.jsp").forward(request, response);
		
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("rec.recomm", request, response);
	}

}