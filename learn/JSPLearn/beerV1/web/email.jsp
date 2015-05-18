<%@ page import="java.util.*" %>
<html>
    <body>
        <h1 align="center" >Admin Email</h1>
        <p/>
        <%
            String emailStr=(String)request.getAttribute("email");
            out.print("<br>Email is: "+emailStr);
        %>
    </body>
</html>