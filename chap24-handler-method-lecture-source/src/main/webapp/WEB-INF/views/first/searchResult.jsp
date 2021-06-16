<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center"/>
	
	<h3>메뉴의 이름 : ${ menuDTO.name }</h3>
	<h3>메뉴의 가격 : ${ menuDTO.price }</h3>
	<h3>메뉴의 카테고리 : ${ menuDTO.categoryCode }</h3>
	<h3>메뉴의 판매상태 : ${ menuDTO.orderableStatus }</h3>
</body>
</html>