<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류</title>
</head>
<body>
<script>
	if("${msg}" != ""){
		alert("${msg}");
	}
	history.go(-1);
</script>
</body>
</html>