<%@page import="member.MemberServiceImpl"%>
<%@page import="member.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctp = application.getContextPath();
	MemberBean member = MemberServiceImpl.getInstance().getSession();
%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>정보 수정</title>
	<link rel="stylesheet" href="<%=ctp%>/css/member.css" />
	<style type="text/css">
	#member_detail{border: 3px solid black; width: 90%;height: 90%; margin: 0 auto;border-collapse: collapse;}
	#member_detail tr{border: 1px solid darkgray; height: 20%;}
	#member_detail tr td{border: 1px solid darkgray; font-size: xx-large;}
	.fontBold{font-weight: bold;}
	.bg_color_yellow{background-color: #A9F5A9;}
	</style>
</head>
<body>
	<div class="box" style="width: 80%;">
		<h1>회원 정보 수정</h1>
		<form action="<%=ctp%>/member/result/update.jsp" method="post">
			<table id="member_detail">
				<tr>
					<td rowspan="2" style="width: 30%;"><img src="<%=ctp%>/img/hhh.jpg" alt="wwwe.com" width="98%" height="98%" /></td>
					<td class="fontBold bg_color_yellow" style="width: 20%;">ID</td>
					<td style="width: 40%;"><%=member.getId() %></td>
				</tr>
				<tr>
					<td class="fontBold bg_color_yellow">PW</td>
					<td><input type="password" name="pw" style="width: 80%;" /></td>			
				</tr>
				
			</table>
			<br />
			<input class="btn" type="submit" value="수 정" />
			<input class="btn" type="reset" value="취 소"/>	
		</form>	
	<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
	<a href="<%=ctp%>/global/main.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
		
	
	</div>
</body>
</html>