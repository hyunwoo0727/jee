<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <!-- 줄 -->
<%
	String ctp = application.getContextPath();
%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
	<style type="text/css">
	div.memberClass{
		font-size: x-large;
	}
	</style>
</head>
<body>
	<div id="" class="memberClass box">
		<h1>회원관리</h1> <br />
		<div style="width: 300px; margin: 0 auto;text-align: left;">
		<ol>
			<li><a href="service/list.jsp">전체보기</a></li>
			<li><a href="service/detail.jsp">내 정보보기</a></li>
			<li><a href="service/update.jsp">내정보수정</a></li>
			<li><a href="service/delete.jsp">탈퇴</a></li>
			<li><a href="service/find_by_id.jsp">검색(ID)</a></li>
			<li><a href="service/find_by.jsp">검색(이름)</a></li>
			<li><a href="service/count.jsp">회원수</a></li>
		</ol>
		</div>
		
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>	
</body>
</html>