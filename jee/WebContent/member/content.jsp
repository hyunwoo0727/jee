<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <!-- 줄 -->
<%
	String ctp = application.getContextPath();
%> 
	<div class="box">
		<h1>회원관리</h1> <br />
		<ol>
			<li><a href="service/list.jsp">전체보기</a></li>
			<li><a href="service/detail.jsp">내 정보보기</a></li>
			<li><a href="service/update.jsp">내정보수정</a></li>
			<li><a href="service/delete.jsp">탈퇴</a></li>
			<li><a href="service/find_by_id.jsp">검색(ID)</a></li>
			<li><a href="service/find_by.jsp">검색</a></li>
			<li><a href="service/count.jsp">회원수</a></li>
		</ol>
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
		<a href="<%=ctp%>/member/service/logout.jsp"><img src="<%=ctp%>/img/logout.png" alt="home" width="50" height="50"/></a>
	</div>	
