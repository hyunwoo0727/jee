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
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
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
	    background-color: #gray;
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
			style="width: 100%; margin: 0 auto; text-align: left;">
			
			<div id="header">
				<h1>학생 관리[Student Management System]</h1>
			</div>

			<div class="box" style="background-color: #EBFFFF;">
				<h2>서비스를 이용하시려면 회원가입을 해야 합니다</h2>
				<a href="<%=ctp%>/member/service/regist.jsp">회원가입</a> <br />
				<a href="<%=ctp%>/member/service/login.jsp">로그인</a>
				<a href="<%=ctp%>/golbal/main.jsp">메인으로</a>
			</div>

			<div id="footer">Copyright � W3Schools.com</div>
		</div>
	</div>
</body>
</html>