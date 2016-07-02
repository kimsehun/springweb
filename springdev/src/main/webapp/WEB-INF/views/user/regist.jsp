<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form id="frmRegist" action="regist" method="post" commandName="userVO">
<table>
	<caption>회원 가입</caption>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="uId"  value="${userVO.uId}" /></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="uPass" value="${userVO.uPass}" /></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="uEmail" value="${userVO.uEmail}" /></td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="uAdress" value="${userVO.uAdress}" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="가입완료" />
		</td>
	</tr>
</table>
</form:form>
</body>
</html>