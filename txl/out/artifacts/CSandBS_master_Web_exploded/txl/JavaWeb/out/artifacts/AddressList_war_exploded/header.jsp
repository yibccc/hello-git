<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/mystyles.css">
    <link rel="stylesheet" type="text/css" href="css/all.css">
    <title>个人通讯录</title>
  </head>
  <script type="text/javascript">
    function logout(){
      if(!confirm("真的要退出吗？")){
        window["event"].returnValue = false;
      }
    }
  </script>
<body>
    <nav class="navbar navbar-light bg-white">
      <a class="navbar-brand text-primary" href="main.jsp">个人通信录</a>
      <ul class="nav justify-content-end">
       <!--  判断若没有用户则 显示登陆跟注册 -->
        <c:if test="${sessionScope.user == null && sessionScope.admin == null}">
          <li class="nav-item active">
            <a class="nav-link" href="login.jsp">登陆</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="register.jsp">注册</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="admin_login.jsp">管理员登陆</a>
          </li>
        </c:if>

        <!-- 判断若有用户则显示 操作-->
        <c:if test="${sessionScope.user != null}">
          <li class="nav-item active">
            <a class="nav-link" href="allfriends.jsp">查看所有通讯录用户</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="allfriends.jsp">修改通讯录用户</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="addfriends.jsp">新增通讯录用户</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">目前登录的用户是 ${sessionScope.user.userName}</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet" onclick="return logout()">退出</a>
          </li>
        </c:if>
        <!-- 判断若有用户则显示 操作-->
        <c:if test="${sessionScope.admin != null}">

          <li class="nav-item active">
            <a class="nav-link" href="admin_index.jsp">目前登录的管理员是 ${sessionScope.admin.adminName}</a>
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet" onclick="return logout()">退出</a>
          </li>
        </c:if>
      </ul>
    </nav>
</body>
</html>