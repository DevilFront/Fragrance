package com.fragrance.web.controller.admin.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.Items;
import com.fragrance.web.service.admin.AdminItemService;

public class Test extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
		req.getRequestDispatcher("/HTML/admin/item/prdlist.jsp").forward(req, resp);
	
	}
	
}
