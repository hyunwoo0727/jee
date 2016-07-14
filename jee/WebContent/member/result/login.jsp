<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberService"%>
<%@ page import="member.MemberBean"%>
<%@ page import="member.MemberServiceImpl" %>
<!doctype html>
<%
	String ctp = application.getContextPath();
	request.setCharacterEncoding("utf-8");
	
	MemberService service = MemberServiceImpl.getInstance();
	MemberBean member = new MemberBean();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id!=null||pw!=null){
		member.setId(id);
		member.setPw(pw);
		String name = service.login(member);
		if(name!=null){
			session.setAttribute("name", name);
			response.sendRedirect(ctp+"/global/main.jsp");
		}
	}
	application.log("넘어온 ID : " + id);
	application.log("넘어온 PW : " + pw);
%>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Insert title here</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
</head>
<body>

	<div class="box" style="margin-top: 10%;">
		
		<h1>로그인 실패!!!!</h1> 
		<br />
		<a href="<%=ctp%>/member/service/login.jsp">다시 로그인</a>
		<%
			application.log("리얼패스"+ctp);
		%>
		<br />
		
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
	</div>
</body>
</html>
