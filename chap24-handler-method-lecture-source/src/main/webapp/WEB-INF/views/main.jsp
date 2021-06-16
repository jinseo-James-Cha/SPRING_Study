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
		HttpServletRequest 파라미터 전달하기
	</button>
	
	<h3>2. @RequestParam로 요청 파라미터 전달 받기</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/first/modify'">
		@RequestParam 파라미터 전달하기
	</button>
	
	<h3>3-1, 3-2. HttpSession 이용하기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath }/first/login'">
		session에 정보담기
	</button>
	
	<h3>4. @RequestBody를 이용하여 파라미터 전달받기</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath }/first/body'">
		@RequestBody 이용하기
	</button>
</body>
</html>