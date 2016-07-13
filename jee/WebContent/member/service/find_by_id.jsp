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
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
	<style>
	body {
		background-color: yelLow;
	}
	h1 {
		color: blue;
	}
	
	p {
		color: red;
	}
	</style>
</head>
<body>
	<div class="box">
		<embed width="100%" height="210px" src="image.jsp">
		<h1>내 정보 보기 페이지</h1>
		<br /> <img src="<%=ctp%>/img/hhh.jpg" alt="W3Schools.com" width="104"
			height="142"><br />
	
	<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
	<a href="<%=ctp%>/global/main.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>
</body>
</html>