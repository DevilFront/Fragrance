package com.fragrance.web.controller.admin.Item;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.service.admin.AdminItemService;



@WebServlet("/admin/item/del")
public class DelController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminItemService service = new AdminItemService();
		try {
			service.deleteItem(id);
		} catch (ClassNotFoundException | SQLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("prdlist");
				
	}
	
}
