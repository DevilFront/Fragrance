package com.fragrance.web.controller.admin.Item;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.fragrance.web.entity.Items;
import com.fragrance.web.service.admin.AdminItemService;

@WebServlet("/admin/item/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminItemService service = new AdminItemService();
		Items items = null;
		
		try {
			items=service.getItem(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("n", items);
		request.getRequestDispatcher("/HTML/admin/item/detail.jsp").forward(request, response);
				
	}
	
}
