package com.fragrance.web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.User;
import com.fragrance.web.service.user.UserServices;

@WebServlet("/reg")
public class UserRegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UserServices service = new UserServices();
		List<User> userList = null;
		User user = new User();
		user.setMail(request.getParameter("email"));
		user.setName(request.getParameter("name"));
		user.setPw(request.getParameter("pw"));
		user.setNickName(request.getParameter("nickname"));
		
		String age=request.getParameter("age");
		try {
			if(service.isNumber(age)) 
				user.setAge(Integer.parseInt(request.getParameter("age")));
			else {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('나이는 숫자를 입력해주세요.'); location.href='/login.jsp#signup';</script>");
				out.flush();
				return;
			}
		} catch (NumberFormatException e) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('나이는 숫자를 입력해주세요.'); location.href='/login.jsp#signup';</script>");
			out.flush();
		} catch (NullPointerException e) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('나이를 입력해주세요.'); location.href='/login.jsp#signup';</script>");
			out.flush();
		}

		String gen = request.getParameter("gender");

		if (gen.equals("man")) {
			user.setGender("남성");
		} else {
			user.setGender("여성");
		}

		

		try {
			result = service.regUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

		}
		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입이 정상적으로 완료되었습니다.'); location.href='/login';</script>");
			out.flush();
		} else if (result != 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 입력입니다.'); location.href='/login.jsp#signup';</script>");
			out.flush();
		}
	}
}