<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1 align="center">SPRING - GSON을 이용한 AJAX</h1>
	
	<h3>1. stream을 이용한 전송</h3>
	<button id="gson1">정보 조회하기</button>
	<table id="memberInfo1" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>			
				<th width="150">이름</th>			
				<th width="100">나이</th>			
				<th width="200">가입일</th>			
			</tr>
		</thead>
		<tbody>
				
		</tbody>
	</table>
	<script>
		$("#gson1").click(function(){
			$.ajax({
				url:"gson1",
				success:function(data,status,xhr){
					console.table(data);
					
					const $table = $("#memberInfo1 tbody");
					$table.html(""); // 공백으로 초기화를 안해주면 버튼한번 누를때마다 데이터가 중첩되어 쌓인다.
					
					for(let index in data){
						$tr = $("<tr>"); // 태그에 대한 내용을 담기위해 변수 $tr 로 선언
						
						$noTd = $("<td>").text(data[index].no);
						$nameTd = $("<td>").text(data[index].name);
						$ageTd = $("<td>").text(data[index].age);
						$enrollDateTd = $("<td>").text(data[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				},
				error:function(xhr, status, error){
					console.log(error);
				}
			});
		});
	</script>
	
	<h3>2. @ResponseBody을 이용한 전송</h3>
	<button id="gson2">정보 조회하기</button>
	<table id="memberInfo2" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>			
				<th width="150">이름</th>			
				<th width="100">나이</th>			
				<th width="200">가입일</th>			
			</tr>
		</thead>
		<tbody>
				
		</tbody>
	</table>
	<script>
		$("#gson2").click(function(){
			$.ajax({
				url : "gson2",
				success:function(data, status, xhr){
					console.table(data);
					
					const $table = $("#memberInfo2 tbody");
					$table.html(""); // 공백으로 초기화를 안해주면 버튼한번 누를때마다 데이터가 중첩되어 쌓인다.
					
					for(let index in data){
						$tr = $("<tr>"); // 태그에 대한 내용을 담기위해 변수 $tr 로 선언
						
						$noTd = $("<td>").text(data[index].no);
						$nameTd = $("<td>").text(data[index].name);
						$ageTd = $("<td>").text(data[index].age);
						$enrollDateTd = $("<td>").text(data[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				},
				error:function(xhr, status, error){
					console.log(error);
				}
			});
		});
	</script>
	
	<h3>3. JsonView를 이용한 BeanNameViewResolver로 응답하기</h3>
	<button id="gson3">정보 조회하기</button>
	<table id="memberInfo3" border="1">
		<thead>
			<tr>
				<th width="100">회원번호</th>			
				<th width="150">이름</th>			
				<th width="100">나이</th>			
				<th width="200">가입일</th>			
			</tr>
		</thead>
		<tbody>
				
		</tbody>
	</table>
	<script>
		$("#gson3").click(function(){
			$.ajax({
				url : "gson3",
				success:function(data, status, xhr){
					console.table(JSON.parse(data.memberList));
					
					const memberList = JSON.parse(data.memberList);
					
					const $table = $("#memberInfo3 tbody");
					$table.html(""); // 공백으로 초기화를 안해주면 버튼한번 누를때마다 데이터가 중첩되어 쌓인다.
					
					for(let index in memberList){
						$tr = $("<tr>"); // 태그에 대한 내용을 담기위해 변수 $tr 로 선언
						
						$noTd = $("<td>").text(memberList[index].no);
						$nameTd = $("<td>").text(memberList[index].name);
						$ageTd = $("<td>").text(memberList[index].age);
						$enrollDateTd = $("<td>").text(memberList[index].enrollDate);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($ageTd);
						$tr.append($enrollDateTd);
						
						$table.append($tr);
					}
				},
				error:function(xhr, status, error){
					console.log(error);
				}
			});
		});
	</script>
	
</body>
</html>