<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	
	<script type="text/javascript">
	
		function getUsers(){	// 데이터 요청 get
			$.ajax({
				url:"users", type:"get", dataType:"json",
				success:function(list){
					console.log(list);
					let msg="";
					list.forEach((data)=> {
						msg += "<b>이름: "+data.name+"</b><br>";
						msg += "<b>나이: "+data.age+"</b><br>";
					})
					// $("#data").html( msg );
					$("#data").append( msg );
					$("#btn").html("더보기");
				},
				error : ()=> { alert("문제 발생"); }
			});
		}
		
		function getUser(){
			let id = $("#name").val();
			
			$.ajax({
				// url:"getUser?id="+id, //getUser?id=홍길동1
				url:"getUser/"+id,	//getUser/홍길동1
				type:"get", dataType:"json",
				success: function(data){
					console.log(data)
					let msg="";
					msg += "<b>이름: "+data.name+"</b><br>";
					msg += "<b>나이: "+data.age+"</b><br>";
					$("#data").html(msg);
					
				}, error: function() {
					console.log("error");
				}
			});
		}
		
		// data 사용 불가 : get, del
		// data 사용 가능 : post, put
		
		function modify(){	// put 데이터 수정
			let modify = {}
			let arr = $("#modify").serializeArray();
			
			arr.forEach((data)=> {
				modify[data.name] = data.value
			})
			console.log(modify);
			
			$.ajax({
				url: "modify", type: "put",
				data: JSON.stringify(modify),
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				success: (result)=> {
					console.log("result: "+ result);
					if(result == 1)
						alert("수정 되었습니다");
				},
				error: () => {
					alert("문제 발생");
				}
			})
		}

		function insert(){ // post 데이터 추가
			let data = {}
			let arr = $("#insert").serializeArray();
			
			arr.forEach((d)=> {
				data[d.name] = d.value
			})
			console.log(data);
			
			$.ajax({
				url: "insert", type: "post",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				success: (result)=> {
					console.log("result: "+ result);
					if(result == 1)
						alert("추가 되었습니다");
				},
				error: () => {
					alert("문제 발생");
				}
			})
		}
	
		function delUser(){	// delete 데이터 삭제
			$.ajax({
				url:"delete/"+$("#id").val(), type:"delete"
			});
		}
	</script>
</head>
<body>
	<div id="data"></div>
	<button type="button" id="btn" onclick="getUsers()">목록보기</button>
	<hr>
	
	검색할 이름: <input type="text" id="name"><br>
	<button type="button" onclick="getUser()">찾기</button>
	<hr>
	
	<h3>수정 modify</h3>
	<form id="modify">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="button" onclick="modify()" value="수정">
	</form>
	<hr>
	
	<h3>추가 post</h3>
	<form id="insert">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="button" onclick="insert()" value="추가">
	</form>
	<hr>
	
	삭제할 이름: <input type="text" id="id"><br>
	<button type="button" onclick="delUser()">삭제</button>
	<hr>
	
</body>
</html>