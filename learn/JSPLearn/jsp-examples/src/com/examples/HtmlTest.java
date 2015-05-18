package com.examples;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlTest extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
        request.setAttribute("currentTip",request.getParameter("tip"));
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/htmldisapper.jsp");
        dispatcher.forward(request,response);
    }
}