package com.fragrance.web.controller.admin.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.Celeb;
import com.fragrance.web.service.admin.AdminBoardService;
import com.fragrance.web.service.admin.AdminItemService;


@WebServlet("/admin/board/boardlist")
public class AdminBoadrdController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
	String[] delIds = req.getParameterValues("del-id");
	
	String cmd = req.getParameter("cmd");
	
	if(cmd.equals("선택삭제")) {
		AdminItemService service = new AdminItemService();
		int[] ids = new int[delIds.length];
		
		for(int i=0; i<delIds.length; i++)
			ids[i] = Integer.parseInt(delIds[i]);
		try {
			int result = service.delItemsAll(ids);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	resp.sendRedirect("boardlist");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int id = 1;
		int count =0;
		String page_ = req.getParameter("p");
		if(page_!=null && !page_.equals(""))
			id = Integer.parseInt(page_);
		AdminBoardService service = new AdminBoardService();
		List<Celeb> list = null;
		try {
			 count = service.getCount();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			list = service.getBoardList(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("admin", list);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/HTML/admin/board/boardlist.jsp").forward(req, resp);
	
	}
}
