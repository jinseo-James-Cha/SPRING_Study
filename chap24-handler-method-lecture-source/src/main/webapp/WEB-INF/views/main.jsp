<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">핸들러 메소드의 Parameter and Annotation</h1>
	
	<h3>1. HttpServletRequest로 요청 파라미터 전달 받기</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/first/regist'">
		파라미터 전달하기
	</button>
</body>
</html>