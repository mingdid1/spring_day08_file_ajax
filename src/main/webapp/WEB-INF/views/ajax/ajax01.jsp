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
			$.ajax({
				url : "ajax01",		// 성공
				// url : "ajax02"	// 실패
				type : "get",
				success : function() {
					$("#txt").html("성공");
				},
				error : ()=> {
					document.getElementById("txt").innerHTML="실패";
				}
			})
			
			fetch("ajax_test");
		}
	</script>
</head>
<body>
	ajax01.jsp<br>
	<h1>1111</h1> <h1>1111</h1> <h1>1111</h1>
	<h1>1111</h1> <h1>1111</h1> <h1>1111</h1>
	<h1>1111</h1> <h1>1111</h1> <h1>1111</h1>
	<button type="button" onclick="test()">클릭</button>
	<hr>
	<b id="txt"></b>
</body>
</html>