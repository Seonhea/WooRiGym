<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="idfindscreen" method = "POST">
			<div class = "search-title">
				<h3>�޴��� ����Ȯ��</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>�̸�</label>
				<input type="text" name="member_name" class = "btn-name" placeholder = "����� �̸�">
			<br>
			</div>
			<div class = "find-phone">
				<label>��ȣ</label>
				<input type="text" onKeyup = "addHypen(this);" name="member_phone" class = "btn-phone" placeholder = "�޴�����ȣ�� '-'���� �Է�">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="button" name="enter" value="ã��"  onClick="">
		<input type="button" name="cancle" value="���" onClick="history.back()">
 	</div>
 </form>
</body>
</html>