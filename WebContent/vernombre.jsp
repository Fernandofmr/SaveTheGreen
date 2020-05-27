<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="IUTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Nombre: <%=request.getParameter("nombre") %> &nbsp; 
		Apellidos: <%=request.getParameter("apellidos") %>

	</body>
</html>