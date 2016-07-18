<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%
	String ctp = application.getContextPath();
%>
<div class="box">
		<h1>성적 관리</h1> <br />
		<ol>
			<li><a href="service/regist.jsp">등록</a></li>
			<li><a href="service/update.jsp">수정</a></li>
			<li><a href="service/delete.jsp">삭제</a></li>
			<li><a href="service/list.jsp">목록</a></li>
			<li><a href="service/count.jsp">카운트</a></li>
			<li><a href="service/search.jsp">검색</a></li>
		</ol>
		<a href="<%=ctp%>/index.jsp"><img src="<%=ctp%>/img/home.png" alt="home" width="50" height="50"/></a>
		<a href="<%=ctp%>/member/service/logout.jsp"><img src="<%=ctp%>/img/logout.png" alt="home" width="50" height="50"/></a>
</div>