<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
 
 	<h1 style="color: green" text align="center">
 	Login Successful
     <%
   Object currUser=
   session.getAttribute("validUser");
     %>
    <h2>UserName=<%=currUser%>
    </h2>
 	</h1>
 
 
</body>
</html>