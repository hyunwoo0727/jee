<%@page import="member.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctp = application.getContextPath();
	
%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원수</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
</head>
<body>
	<div class="box">
	<h2>현재 회원은 <%=MemberServiceImpl.getInstance().count()%> 명 입니다</h2>  <br />
	
	<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
	<a href="<%=ctp%>/global/main.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>
</body>
</html>