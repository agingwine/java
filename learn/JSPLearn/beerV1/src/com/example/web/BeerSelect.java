package com.example.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.example.model.*;

public class BeerSelect extends HttpServlet{
        public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
            String c=request.getParameter("color");
            BeerExpert be=new BeerExpert();
            List results=be.getBrands(c);
            request.setAttribute("styles",results);
            RequestDispatcher view=request.getRequestDispatcher("result.jsp");
            view.forward(request,response);
        }
}