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
	table {
		font-family: arial, sans-serif;
		border-collapse: collapse;
		width: 100%;
	}
	
	td, th {
		border: 1px solid #dddddd;
		text-align: left;
		padding: 8px;
	}
	
	tr:nth-child(even) {
		background-color: #dddddd;
	}
	</style>
</head>
<body>
	<div class="box">
		목록보기 <br />
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>REGDATE</th>
				<th>BIRTH</th>
			</tr>
			<tr>
				<td>hong</td>
				<td><a href="detail.jsp">홍길동</a></td>
				<td>2016-07-11</td>
				<td>870727-1</td>
			</tr>
			<tr>
				<td>lee</td>
				<td><a href="detail.jsp"></detail>이순신</a></td>
				<td>2016-07-112</td>
				<td>890625-1</td>
			</tr>
		</table>

		<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
		<a href="<%=ctp%>/global/main.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>
</body>
</html>