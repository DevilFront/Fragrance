package com.fragrance.web.controller.admin.Item;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fragrance.web.entity.Items;
import com.fragrance.web.service.admin.AdminItemService;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, 
		maxFileSize = 100 * 1024 * 1024, 
		maxRequestSize = 300 * 1024 * 1024)

@WebServlet("/admin/item/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("/HTML/admin/item/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("확인");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("prd-name");
		String brand = request.getParameter("brand-name");
		String size_ = request.getParameter("ml");
		int size = Integer.parseInt(size_);
		String price_ = request.getParameter("price");
		int price = Integer.parseInt(price_);
		String scent = request.getParameter("scent");
		String gender = request.getParameter("gender");
		String type = request.getParameter("type");
		String content = request.getParameter("scentexp");
		String tag = request.getParameter("tag");

		Part filepart = request.getPart("file");
		String filename = filepart.getSubmittedFileName();
		InputStream fis = filepart.getInputStream();

		String realpath = request.getServletContext().getRealPath("/images");
		System.out.println(realpath);

		String filepath = realpath + File.separator + filename;
		System.out.println(filepath);
		FileOutputStream fos = new FileOutputStream(filepath);

		byte[] buf = new byte[1024];
		int sizeb = 0;
		while ((sizeb = fis.read(buf)) != -1)
			fos.write(buf, 0, sizeb);
		fos.close();
		fis.close();


		// 데이터 등록
		Items items = new Items();
		items.setImg(filename);
		items.setName(name);
		items.setBrand(brand);
		items.setSize(size);
		items.setPrice(price);
		items.setScent(scent);
		items.setGender(gender);
		items.setType(type);
		items.setContent(content);
		items.setTag(tag);

		AdminItemService service = new AdminItemService();
		try {
			service.insertItem(items);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service);

		response.sendRedirect("prdlist");
	}
}
