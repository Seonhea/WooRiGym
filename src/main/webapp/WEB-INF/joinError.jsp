<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var pw1 = $("#pw1").value();
		var pw2 = $("#pw2").value();
		console.log(pw1);
		console.log(pw2);
		if(pw1 != pw2){
			alert("�����ϰ� �Է����ּ���");
			return false;
		} 
		var regExp = /^[A-Z][A-za-z0-9_!]{7,15}$/;
		if(!regExp.test(pw1)){
			alert("���� ��ҹ���  + ���� + Ư������(_#) ���ǿ� �°� �Է����ּ���.");
			return false;
		}
		
		var name = $("#name")
		</script>
</body>
</html>