<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"> Spring MVC Mapping Test</h1>
	
	<!-- 1. get방식 post방식 따로보내고 controller에서는 같이 받아서 처리한다 -->
	<h2>1. 메소드에 요청 매핑하기</h2>	
	<h3>GET : /menu/regist</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/regist'"}>
		GET 메뉴 등록 요청
	</button>
	
	<h3>POST : /menu/regist</h3>
	<form action="${pageContext.servletContext.contextPath}/menu/regist" method="post" >
		<button type="submit">post 메뉴 등록 요청</button>
	</form>
	
	<!-- 2. 이번에는 get방식과 post방식의 요청처리를 구분해서 확인하자 -->
	<h3>GET : /menu/modify</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/modify'"}>
		GET 메뉴 수정 요청
	</button>
	
	<h3>POST : /menu/modify</h3>
	<form action="${pageContext.servletContext.contextPath}/menu/modify" method="post" >
		<button type="submit">post 메뉴 등록 요청</button>
	</form>
	
	<!-- 3. @GetMapping or @PostMapping을 이용해서 매핑하기 -->
	<h3>GET : /menu/delete</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/menu/delete'"}>
		GET 메뉴 삭제 요청
	</button>
	
	<h3>POST : /menu/delete</h3>
	<form action="${pageContext.servletContext.contextPath}/menu/delete" method="post" >
		<button type="submit">post 메뉴 등록 요청</button>
	</form>
</body>
</html>