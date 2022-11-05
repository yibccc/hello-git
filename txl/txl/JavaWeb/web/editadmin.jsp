<%@ page import="User.Domain.Friend" %>
<%@ page import="User.Dao.FriendDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="User.Domain.User" %>
<%@ page import="User.Dao.UserDao" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>修改通讯录用户</title>
  <script type="text/javascript">
    function submit(){
      if(!confirm("确认提交吗？")){
        window["event"].returnValue = false;
      }
    }
  </script>
</head>
<body>
	<%@ include file="header.jsp" %>
    <%
        UserDao userDao = new UserDao();
        User user =userDao.getUserById(request.getParameter("userid"));
    %>
	<!-- 正文     创建时间  -->
    <div id="home">
      <ul class="nav nav-tabs">        
        <li class="nav-item active">
          <a class="nav-link" data-toggle="tab" href="#userlist">编辑用户资料</a>
        </li>
      </ul>
      <div class="tab-content" id="myTabContent">        
        <div class="tab-pane fade show active" id="userlist" role="tabpanel" aria-labelledby="profile-tab">
          <div id="friendform">      
              <form action="${pageContext.request.contextPath}/EditUserServlet?userid=<%=user.getUserID()%>" method="post">
                <div class="form-group row">
                  <input type="hidden" name="id" value="" />
                  <label for="username" class="col-sm-2 col-form-label">用户姓名</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name = "username" value="<%=user.getUserName()%>">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="password" class="col-sm-2 col-form-label">用户密码</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="password" name = "password" value="<%=user.getPassword()%>">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="phoneid" class="col-sm-2 col-form-label">电话号码</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="phoneid" name = "phoneid" value="<%=user.getPhoneID()%>">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="email" class="col-sm-2 col-form-label">电子邮箱</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name = "email" value="<%=user.getEmail()%>">
                  </div>
                </div>
                <div class="form-group rowcenter">
                  <button type="submit" class="btn btn-primary mr-3">提交</button>
                  <button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
                </div>
              </form>
          </div>
        </div>        
      </div>
    </div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>