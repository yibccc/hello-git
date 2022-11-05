<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="js/register.js"></script>
    <style type="text/css">
        .msg{
            color: red;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
    <div id="login">
        <div>
            <div class="form-group" align="center">
                <a href="main.jsp">
                    <img src="${pageContext.request.contextPath}/images/JACK.ico"  alt="">
                </a>
            </div>
            <div class="form-group" align="center" >通讯录用户注册</div>
        </div>

        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post" id="form">
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder = "请输入不为空的用户名" onblur="checkUsername()">
                <span  class="msg" id="userErr">${requestScope.nameRegisterError}</span>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder = "请输入不少于六位密码" onblur="checkPassword()">
                <span  class="msg" id="pwdErr"></span>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="repassword" name="repassword" placeholder = "请输入确认密码" onblur="checkRepassword()">
                <span  class="msg" id="repwdErr"></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="phoneid" name="phoneid" placeholder = "请输入手机号码" onblur="checkTel()">
                <span  class="msg" id="phoneErr"></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="email" name="email" placeholder = "请输入邮箱号码" onblur="checkEmail()">
                <span class="msg" id="emailErr"></span>
            </div>

            <div align="center">
                <button type="submit" class="btn btn-primary" onclick="return reg()">注册</button>
                <button type="reset" class="btn btn-primary">取消</button>
            </div>

            <div align="center">
                <span>点击 “注册” 按钮，即表示您同意并愿意遵守</span><a href="https://account.cnblogs.com/agreement">用户协议</a>
            </div>
        </form>

    </div>
</body>
</html>
