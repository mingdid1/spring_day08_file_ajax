<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="mod" method="post" enctype="multipart/form-data">
		<input type="text" name="id" readonly value=${dto.id }><br>
		<input type="text" name="name" value=${dto.name }><br>
		<input type="file" name="file" value=${dto.imgName }><br>
		<input type="submit" value="수정"><br>
	</form>
</body>
</html>