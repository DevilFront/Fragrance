package com.fragrance.web.controller.admin.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.User;
import com.fragrance.web.service.admin.AdminUserService;


@WebServlet("/admin/user/userlist")
public class AdminUserController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
	    resp.setContentType("UTF-8");
	String[] delIds = req.getParameterValues("del-id");
	
	String cmd = req.getParameter("cmd");
	System.out.println(cmd);
	
	if(cmd.equals("선택삭제")) {
		AdminUserService service = new AdminUserService();
		int[] ids = new int[delIds.length];
		
		for(int i=0; i<delIds.length; i++)
			ids[i] = Integer.parseInt(delIds[i]);
		try {
			int result = service.delUserAll(ids);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	req.getRequestDispatcher("/HTML/admin/user/userlist.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int id = 1;
		int count =0;
		String page_ = req.getParameter("p");
		if(page_!=null && !page_.equals(""))
			id = Integer.parseInt(page_);
		AdminUserService service = new AdminUserService();
		List<User> list = null;
		try {
			 count = service.getUserCount();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(count);
		
		try {
			list = service.getUserList(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("admin", list);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/HTML/admin/user/userlist.jsp").forward(req, resp);
	
	}
}
