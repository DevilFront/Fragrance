package com.fragrance.web.controller.recommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.Items;
import com.fragrance.web.service.RecommentService;
import com.google.gson.Gson;

//占쌕몌옙 占십울옙占쏙옙 list 占쏙옙트占싼뤄옙占쏙옙 占쏙옙占쏙옙占� 占쌘드만 占쏙옙체占싹곤옙 占쌍놂옙占쏙옙占싱쇽옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쌍몌옙홱占�.
@WebServlet("/HTML/rec/recomm-data")
public class RecommentRestController extends HttpServlet{
	
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
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}


