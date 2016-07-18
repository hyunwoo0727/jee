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
	<title>404 ERROR PAGE NOT FOUND</title>
	<link href="<%=ctp%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main">
		<!-- header -->
		<div id="header">
			<h1>No pages here as you see!<span>404 error - not found.</span></h1>
		</div>
		<!-- content -->
		<div id="content">
			<ul class="nav">
         	<li class="home"><a href="<%=ctp%>/index.jsp">Home Page</a></li>
            <li class="site_map"><a href="#">Site Map</a></li>
            <li class="search"><a href="#">Website Search</a></li>
         </ul>
         <p>Unless creepy emptiness was what you were looking for, this place has nothing that you want.<br /> 
         So please either go to our <a href="#">homepage</a>, <a href="#">sitemap</a> or try using the <a href="#">website search</a>.</p>
		</div>
	
		
	</div>
</body>
</html>