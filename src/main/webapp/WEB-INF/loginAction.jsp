<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="woorigym.user.model.service.UserService" %>
    <%@ page import="java.io.PrintWriter" %>
    <% request.setCharacterEncoding("UTF-8"); %>
   	<jsp:useBean id="user" class="woorigym.user.model.vo.UserTable" scope="page"/>
   	<jsp:setProperty name="user" property="user_id"/>
   	<jsp:setProperty name="user" property="user_pwd"/>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log</title>
</head>
<body>
	<%
		UserService userdao = new UserService();
		int result = userdao.Login(user.getUser_id(), user.getUser_pwd());
		if(result == 1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("<script>");
		}
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("<script>");
		}
		else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("<script>");
		}
		else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("<script>");
		}
	%>
</body>
</html>