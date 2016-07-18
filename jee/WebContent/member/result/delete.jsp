<%@page import="member.MemberService"%>
<%@page import="member.MemberBean"%>
<%@page import="member.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctp = application.getContextPath();
	MemberBean member = new MemberBean();
	member.setId(request.getParameter("id"));
	member.setPw(request.getParameter("pw"));
	if(MemberServiceImpl.getInstance().delete(member)==1){
		response.sendRedirect(ctp+"/index.jsp");
		return;
	}
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
		
		<h1>비밀번호가 다릅니다</h1> 
		<br />
		<a href="<%=ctp%>/member/service/delete.jsp">다시 시도</a>
		<br />
		
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>
</body>
</html>