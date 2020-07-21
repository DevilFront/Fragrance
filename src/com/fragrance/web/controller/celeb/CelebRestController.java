package com.fragrance.web.controller.celeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fragrance.web.entity.Celeb;
import com.fragrance.web.service.CelebService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/HTML/celeb/celeb-data")// data -> xml ,csv,json
public class CelebRestController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");
      
         CelebService service = new CelebService();
         int id=0;
         String page_ = request.getParameter("p");
         if(page_!=null && !page_.equals(""))
             id = Integer.parseInt(page_);
         Celeb celeb = null;
      
         try {
            celeb = service.getCelebdetail(id);
         } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         String json=  gson.toJson(celeb);
         PrintWriter out =  response.getWriter();
         out.write(json);
   }
}