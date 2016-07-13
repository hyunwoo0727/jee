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
</head>
<body>
	<div class="box" style="margin-top: 10%;">
		<form action="<%=ctp%>/member/result/login.jsp" method="post">
			<span class="meta">ID</span> <input type="text" name="id" style="width: 60%"/> <br/>
			<span class="meta">비밀번호</span> <input type="password" name="pw" style="width: 60%"/> <br/>
			<br /><br />
			<input class="btn" type="submit" value="로그인"/>
			<input class="btn" type="reset" value="취 소" />
		</form> 
		<br />
		<br />
	</div>
</body>
</html>