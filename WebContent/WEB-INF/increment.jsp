<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	
//	response.sendRedirect("list.nhn?currentPage=" + currentPage);

	response.sendRedirect("contentView.nhn?idx=" + idx + "&currentPage=" + currentPage);
%>

</body>
</html>