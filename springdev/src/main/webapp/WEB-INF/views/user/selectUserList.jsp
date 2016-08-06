<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>no</th>
	<th>id</th>
	<th>password</th>
	<th>email</th>
	<th>address</th>
</tr>
<c:forEach items="${list}" var="UserVO" varStatus="st">
<tr>
	<td>${st.count}</td>
	<td><a href="/user/update/${UserVO.uNumber}">${UserVO.uId}</a></td>
	<td>${UserVO.uPass}</td>
	<td>${UserVO.uEmail}</td>
	<td>${UserVO.uAdress}</td>
</tr>
</c:forEach>
</table>
</body>
</html>