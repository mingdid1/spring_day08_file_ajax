<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
		function test() {
			let frm = {}
			let arr = $("#frm").serializeArray();
			
			for(var i=0; i<arr.length; i++)
				frm[arr[i].name] = arr[i].value;
			
			$.ajax({
				url: "result04", type: "POST",
				data: JSON.stringify(frm),	// 서버로 전송 할 데이터
				contentType: "application/json; charset=utf-8",	// 서버로 보낼 데이터 유형
				dataType: "json",	// 서버로 받을 리턴 타입 지정
				success: function(data){
					console.log("이름 : "+ data.name)
					console.log("나이 : "+ data.age)
					console.log("nick : "+ data.nick)
				}
			});
		}
	</script>
</head>
<body>
	ajax04.jsp<br>
	<form id="frm">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="pwd"><br>
		<input type="text" name="age"><br>
		<input type="text" name="addr"><br>
		<input type="button" value="클릭" onclick="test()">
	</form>
</body>
</html>