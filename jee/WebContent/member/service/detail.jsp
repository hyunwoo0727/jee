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
	<style type="text/css">
	#member_detail{border: 3px solid black; width: 90%;height: 90%; margin: 0 auto;border-collapse: collapse;}
	#member_detail tr{border: 1px solid darkgray; height: 20%;}
	#member_detail tr td{border: 1px solid darkgray; font-size: xx-large;}
	.fontBold{font-weight: bold;}
	.bg_color_yellow{background-color: #A9F5A9;}
	</style>
</head>
<body>
	<!--  id birth name regdate gender proflieImg -->
	<div class="box" style="width: 80%;">
		<h1>회원 정보</h1>
		<table id="member_detail">
			<tr>
				<td rowspan="3" style="width: 30%;"><img src="<%=ctp%>/img/hhh.jpg" alt="wwwe.com" width="98%" height="98%" /></td>
				<td class="fontBold bg_color_yellow" style="width: 20%;">ID</td>
				<td style="width: 40%;">hong</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">NAME</td>
				<td>홍길동</td>			
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">성별</td>
				<td >남</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">생년월일</td>
				<td colspan="2">d</td>
			</tr>
			<tr>
				<td class="fontBold bg_color_yellow">등록일</td>
				<td colspan="2">d</td>
			</tr>
		</table>		
	<a href="<%=ctp%>/member/member_controller.jsp"><img src="<%=ctp%>/img/member.gif" alt="" width="50" height="50"/></a>
	<a href="<%=ctp%>/global/main.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
		
	
	</div>
</body>
</html>