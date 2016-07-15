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
	<title>Insert title here</title>
	<style>
	#header {
		background-color: black;
		color: white;
		text-align: center;
		padding: 5px;
	}
	#section {
		width: 350px;
		float: left;
		padding: 10px;
	}
	
	#footer {
		background-color: black;
		color: white;
		clear: both;
		text-align: center;
		padding: 5px;
	}
	#nav ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    background-color: #333;
	}
	
	li {
	    float: left;
	    border-right:1px solid #bbb;
	}
	
	li:last-child {
	    border-right: none;
	}
	
	li a {
	    display: block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	
	li a:hover:not(.active) {
	    background-color: #111;
	}
	
	.active {
	    background-color: #4CAF50;
	}
	</style>
</head>
<body>
	<div>
		<div
			style="width: 50%; margin: 0 auto; text-align: left; background-color: #EBFFFF">
			
			<div id="header">
				<h1>학생 관리[Student Management System]</h1>
			</div>

			<div id="nav">
				<ul>
				<li class="active"><a href="<%=ctp%>/member/member_controller.jsp">회원관리</a></li>
				<li><a href="#">성적관리</a></li>
				<li><a href="#">계좌관리</a></li>
				<li><a href="#">학교소개</a></li>
				</ul>
			</div>
			
			<div id="section">
				<h2>회원관리 <%=session.getAttribute("name")+" 님 환영합니다" %></h2>
				<p></p>
				<p></p>
			</div>

			<div id="footer">Copyright � W3Schools.com</div>
		</div>
	</div>
</body>
</html>