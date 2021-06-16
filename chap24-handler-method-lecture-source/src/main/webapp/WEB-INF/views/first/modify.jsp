<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">@RequestParam을 이용하여 전달된 파라미터 꺼내기</h1>
	
	<h3>메뉴 수정하기</h3>
	<form action="modify" method="post">
		수정할 메뉴의 이름 : <input type="text" name="modifyName"><br>
		수정할 메뉴의 가격 : <input type="number" name="modifyPrice"><br>
		<button type="submit">수정하기</button>
	</form>
	
	<h3>메뉴 수정하기 2</h3>
	<form action="modifyAll" method="post">
		수정할 메뉴의 이름 : <input type="text" name="modifyName2"><br>
		수정할 메뉴의 가격 : <input type="number" name="modifyPrice2"><br>
		<button type="submit">수정하기</button>
	</form>
	
	<h3>3. @ModelAttribute를 이용하여 파라미터 전달 받기</h3>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/first/search'">
		@ModelAttribute 이용하기
	</button>
</body>
</html>