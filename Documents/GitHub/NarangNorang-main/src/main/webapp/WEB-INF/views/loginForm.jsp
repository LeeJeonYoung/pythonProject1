<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>로그인</h1>
	<jsp:include page="member/loginForm.jsp" flush="true" /><br>
	<a href="/narangnorang/findPw">Forgot Password?</a><br>
	<a href="/narangnorang/signUp">회원 가입</a>
</body>
</html>