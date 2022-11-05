<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id="login">

      <div>
          <div class="form-group" align="center">
              <a href="main.jsp">
                  <img src="${pageContext.request.contextPath}/images/Bee.ico" >
              </a>
          </div>
          <div class="form-group" align="center" >通讯录管理员登录</div>
      </div>

      <form action="${pageContext.request.contextPath}/AdminLoginServlet" method="post">
        <div class="form-group">
          <input type="text" class="form-control" id="username" name="username" placeholder = "管理员">
        </div>
        <div class="form-group">
          <input type="password" class="form-control" id="password" name="password" placeholder = "密码">
        </div>

        <div align="center">
            <button type="submit" class="btn btn-primary">登录</button>
        </div>

        <div>
            <span>没有账号，不能注册，请联系管理员</span><a href="main.jsp">点此返回首页</a>
        </div>
      </form>

    </div>
</body>
</html>