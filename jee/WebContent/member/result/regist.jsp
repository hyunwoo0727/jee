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
	<title>회원가입</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
	<style type="text/css">
	div.joinDiv{
		border: 2px solid gray; width: 80%; margin: 10px 50px 10px 50px;
	}
	span.meta{
		width: 200px; background-color: powderblue; float: left; text-align: center; font-weight: bold; border-right: 1px solid black; 
	}
	</style>
</head>
<body>
	<!-- <object width="100%" height="500px" data="../../global/school_info.html"></object> -->
	<div class="box">
		
			<span class="meta">이름</span> <%=request.getParameter("name") %> <br/>
			<hr style="margin: 0;">
			<span class="meta">ID</span> <%=request.getParameter("id") %> <br/>
			<hr style="margin: 0;">
			<span class="meta">비밀번호</span> <%=request.getParameter("pw") %> <br/>
			<hr style="margin: 0;">
			<span class="meta">SSN</span> <%=request.getParameter("ssn") %> <br/>
			<hr style="margin: 0;">
			<span class="meta">전공</span> <%=request.getParameter("major") %> <br/>
			<hr style="margin: 0;">
			<span class="meta">수강과목</span> 
			<%
				String[] subjects = request.getParameterValues("subject");
				if(subjects !=null){
					for(String subject : subjects){
			%>
						<%=subject %>
			<%
					}
				}
			%>
			<hr style="margin: 0;">
			<br/>
			
			
			회원가입 축하드립니다 <%=request.getParameter("name") %> 님..
		
		<br />
		<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
		
		
	</div>
</body>
</html>