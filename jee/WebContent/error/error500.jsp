<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctp = application.getContextPath();
	request.setCharacterEncoding("utf-8");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ERROR 500</title>
	<link href="<%=ctp%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<!-- header -->
	<img src="<%=ctp%>/img/error-500.jpg" width="100%" height="30%" style="margin: 0 auto;" alt="" />
	</div>
</body>
</html>