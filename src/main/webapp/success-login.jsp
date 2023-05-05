<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 	String accountName="";
 accountName = request.getParameter("accountName1");
 %>
	Welcome back <%=accountName %>
</body>
</html>