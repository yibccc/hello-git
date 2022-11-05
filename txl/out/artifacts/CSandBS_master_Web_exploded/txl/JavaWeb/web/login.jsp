<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆页面</title>
    <style type="text/css">
        .msg{
            color: #ff0000;
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id="login">

      <div>
          <div class="form-group" align="center" >通讯录用户登录</div>
      </div>

      <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="form-group">
          <input type="text" class="form-control" id="username" name="username" placeholder = "登陆用户名">
            <span class="msg">${requestScope.namemsg}${requestScope.nameError}</span>
        </div>
        <div class="form-group">

            <input type="password" class="form-control" id="password" name="password" placeholder = "密码">
            <span class="msg">${requestScope.pwdError}${requestScope.pwdmsg}</span>
        </div>
        <div class="form-group form-check">
          <input type="checkbox" class="form-check-input" id="rememberpassword">
          <label class="form-check-label" for="rememberpassword" name="remember">记住我</label>
        </div>

        <div align="center">
            <button type="submit" class="btn btn-primary">登录</button>
        </div>

        <div>
            <span>没有账号，</span><a href="register.jsp">立即注册</a>
        </div>
      </form>

    </div>
</body>
</html>