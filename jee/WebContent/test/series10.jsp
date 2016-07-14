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
</head>
<body>
<%-- 	<%
		int sum = 0;
		for(int i=1; i <=10; i++){
			sum += i;
			if(i==10){
	%>
			<%=i%> = 			
	<%
			}else{
	%>
			<%=i%> + 
	<%			
				
			}
		}
	%>
		<%=sum%> --%>
	<%
		int sum2 = 0;
		for(int i=0; i <=10; i++){
			sum2 += i;
			if(i==0) continue;
	%>
			<%=i==10? i+"=" : i+"+"%>
	<%
		}
	%>
		<%= sum2 %>
</body>
</html>