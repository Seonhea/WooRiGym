
<!-- ��� CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/template_header.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- ��Ʈ��Ʈ�� CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<style>
#head {
	text-align: center;
}

#login-btn {
	text-emphasis-color: gray;
	background-color: black;
}

#login-menu {
	text-align: center;
}

#login-menu>ul {
	list-style-type: none;
	position: relative;
}

#login-menu li {
	display: inline-block;
}

/* ���̵� | ��й�ȣ ã�� | ȸ������ */
#login-menu li::after {
	padding: 10px;
	content: "|";
}

#login-menu li:last-child::after {
    padding: 15px;
    content: "";
}
.form-group{
	text-align:center;
}

</style>
</head>
<body>
            <!-- ������� ���ø� -->
            <%@ include file="template_header.jsp" %>

                <div class="container">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>

                        <div class="container">
                            <form id= "log-box" method="post" action="findPwd">
                                <h4 id="head">���̵� ã��</h4>

                                <div class="form-group">
                                    	���̵�<input type="text" placeholder="���̵�" name="user_id"><br>
                                </div>
                                <div class="form-group">
                                    	�̸���<input type="text" placeholder="@���� �ۼ�" name="email" maxlength="20"><br>
                                </div>
                                <div class="form-group">
                                <input type="submit" value="��й�ȣ ã��">
                                </div>
                            </form>
                                <div id="login-menu">
                                    <ul>
                                        <li><a href="findId">���̵�</a></li>
                                        <li><a href="findPwd">��й�ȣ ã��</a></li>
                                        <li><a href="join">ȸ������</a></li>
                                    </ul>
                                </div>

                        </div>
                    </div>
                </div>
        </body>

        </html>