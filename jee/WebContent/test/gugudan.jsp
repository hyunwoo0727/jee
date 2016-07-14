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
<body style="font-weight: bold;">
	<table style="margin: 0 auto;">
	<%
		int i=0,j=0,k=0;
		for(i=0; i < 2 ; i++){
			for(j=1; j < 10 ; j++){
	%>
		<tr>
	<%
				for(k=2+(i*4); k < 6+(i*4);k++){
	%>   
	           	<td width="100" style="font-size: x-large;"><%=k+"*"+j+"="+k*j %> </td>
	<%
				}
	%>
		<tr/>
	<%
			}
		}
	%>
	</table>
</body>
</html>