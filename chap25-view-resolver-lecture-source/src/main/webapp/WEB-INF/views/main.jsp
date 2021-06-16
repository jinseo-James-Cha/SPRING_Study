<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">View Resolver를 이용한 뷰 연결하기</h1>
	
	<h3>문자열로 뷰 이름 반환하기</h3>
	<button onclick="location.href='string'">문자열로 뷰 이름 반환</button>
	
	<h3>문자열로 redirect 하기</h3>
		<button onclick="location.href='string-redirect'">문자열로 뷰 이름 반환하여 리다이렉트</button>
	<script>
		console.log(decodeURIComponent('${param.message}'));
		const message = decodeURIComponent('${param.message}').replaceAll("+", " ");
		console.log(message);
	</script>
</body>
</html>