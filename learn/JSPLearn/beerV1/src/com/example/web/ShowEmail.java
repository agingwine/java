package com.example.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShowEmail extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        request.setAttribute("email",getServletConfig().getInitParameter("adminEmail"));
        RequestDispatcher view=request.getRequestDispatcher("email.jsp");
        view.forward(request,response);
    }
}