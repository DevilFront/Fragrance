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

//�ٸ� �ʿ��� list ��Ʈ�ѷ��� ����� �ڵ常 ��ü�ϰ� �ֳ����̼����� �������ָ�ȴ�.
@WebServlet("/HTML/rec/result")
public class ResultController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		RecommentService service = new RecommentService();
		List<Items> list = null;
		String gender =request.getParameter("gender");
		String age =request.getParameter("age");
		String season =request.getParameter("season");
		String scent =request.getParameter("scent");
		
		
		try {
			list = service.getResultList(gender, age, season, scent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	request.setAttribute("result", list);
	TilesContainer container = TilesAccess.getContainer(
	        request.getSession().getServletContext());
	container.render("rec.result", request, response);
	
	}

}