<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>id</th>
	<th>password</th>
	<th>email</th>
	<th>address</th>
</tr>

<tr>
	<th>${userVO.uId}</th>
	<th>${userVO.uPass}</th>
	<th>${userVO.uEmail}</th>
	<th>${userVO.uAdress}</th>
</tr>
</table>
</body>
</html>