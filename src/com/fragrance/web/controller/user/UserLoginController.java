package com.fragrance.web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fragrance.web.entity.User;
import com.fragrance.web.service.user.UserServices;

@WebServlet("/login")
public class UserLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp#signin").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		User user = new User();

		UserServices service = new UserServices();

		try {
			result = service.doLogin(request.getParameter("email"), request.getParameter("pw"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		if (result == 1) { // Login 성공시
			try { //로그인 성공시 , 역할과 닉네임 얻어옴. 
				String role = service.checkRole(request.getParameter("email"));
				String nickName=service.checknickName(request.getParameter("email"));
				session.setAttribute("isAdmin", role);
				session.setAttribute("nickName", nickName);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/index");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디 또는 패스워드가 일치하지 않습니다.'); location.href='/login.jsp#signup';</script>");
			out.flush();
		}
	}
}