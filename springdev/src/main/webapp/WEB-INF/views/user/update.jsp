<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/user/updateAction">
<input type="hidden" name="uNumber" value="${userVO.uNumber}"/>
<table>
<tr>
	<th>id</th>
	<td><input type="text" name="uId" value="${userVO.uId}"/></td>
</tr>
<tr>
	<th>password</th>
	<td><input type="text" name="uPass" value="${userVO.uPass}"/></td>
</tr>
<tr>
	<th>email</th>
	<td><input type="text" name="uEmail" value="${userVO.uEmail}"/></td>
</tr>
<tr>
	<th>address</th>
	<td><input type="text" name="uAdress" value="${userVO.uAdress}"/></td>
</tr>
<tr><td colspan="2" >
<input type="submit" value="수정" />
<input type="button" value="목록" onclick="javascript:location.href='/user/selectUserList'" />
</td>
</tr>
</table>
</form>
</body>
</html>