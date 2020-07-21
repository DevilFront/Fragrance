package com.fragrance.web.controller.common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fragrance.web.commonservice.CommentServices;
import com.fragrance.web.entity.Reply;
import com.fragrance.web.entity.User;

@WebServlet("/HTML/rank/delete")
public class DeleteCommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		int commentId = Integer.parseInt(request.getParameter("commentid"));
		int id=Integer.parseInt(request.getParameter("id"));
		Reply reply = new Reply();
		List<Reply> replys = null;
		User user = new User();

		CommentServices service = new CommentServices();

		try {
			service.deleteComment(commentId);
			System.out.println(commentId);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		detail?id=32
		response.sendRedirect("detail?id=" + id);
	}
}