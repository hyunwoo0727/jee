<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 가입</title>
</head>
<body>
	<form action="" method="post">
		이름 : <input type="text" name="name" /> <br/>
		ID : <input type="text" name="id" /> <br/>
		비밀번호 : <input type="text" name="pw"/> <br/>
		SSN : <input type="text" name="ssn" /> <br/>
		통신사 : <input type="checkbox" name="SKT" value="SKT"/>SKT
				  <input type="checkbox" name="KT" value="KT"/>KT
		          <input type="checkbox" name="LG" value="LG"/>LG <br />
		성별 :
		<input type="radio" name="gender" value="male" />남자
		<input type="radio" name="gender" value="female" />여자 <br />
		<input type="submit" value="회원가입" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>