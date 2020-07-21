package com.fragrance.web.controller.admin.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.User;
import com.fragrance.web.service.admin.AdminUserService;





@WebServlet("/admin/user/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminUserService service = new AdminUserService();
		User user = null;
		
		try {
			user=service.getUser(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("n", user);
		request.getRequestDispatcher("/HTML/admin/user/edit.jsp").forward(request, response);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("UTF-8");
	    
	    	String userNum_ = request.getParameter("userNum");
	    	int userNum = Integer.parseInt(userNum_);
	      String mail = request.getParameter("mail");
	      String pw = request.getParameter("pw");
	      String nickName = request.getParameter("nickName");
	      String name = request.getParameter("name");
	      String age_ = request.getParameter("age");
	      int age =  Integer.parseInt(age_);
	      String gender = request.getParameter("gender");
	      String role = request.getParameter("role");
	      System.out.println(role);
	      System.out.println(age);
		
	      User user = new User();
	      user.setUserNum(userNum);
	      user.setMail(mail);
	      user.setPw(pw);
	      user.setNickName(nickName);
	      user.setName(name);
	      user.setAge(age);
	      user.setGender(gender);
	      user.setRole(role);
	     
		
		AdminUserService service = new AdminUserService();
		try { 
			service.updateUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("userlist");

	}
	
}
