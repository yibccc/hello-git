<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">

  <!-- my style CSS -->
  <link rel="stylesheet" type="text/css" href="css/mystyles.css">
  <link rel="stylesheet" type="text/css" href="css/all.css">
  <title>个人通信录</title>
  <script type="text/javascript">
    function del(){
      if(!confirm("确认要删除？")){
        window.event.returnValue = false;
      }
    }

  </script>
</head>
<body>
<%@ include file="header.jsp" %>

<!-- 正文  -->
<div id="home">
  <ul class="nav nav-tabs">
    <li class="nav-item active">
      <a class="nav-link" data-toggle="tab" href="#userlist">用户管理</a>
    </li>
  </ul>
  <div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="userlist" role="tabpanel" aria-labelledby="profile-tab">
      <div>
        <table class="table table-hover">
          <thead>
          <tr>
            <th scope="col">用户ID</th>
            <th scope="col">用户姓名</th>
            <th scope="col">用户密码</th>
            <th scope="col">电话号码</th>
            <th scope="col">电子邮箱</th>
            <th scope="col">操作</th>
          </tr>
          </thead>
          <tbody>


            <c:forEach items="${sessionScope.usersList}" var="ul">

                <tr>
                  <td scope="col">${ul.userID}</td>
                  <td scope="col">${ul.userName}</td>
                  <td scope="col">${ul.password}</td>
                  <td scope="col">${ul.phoneID}</td>
                  <td scope="col">${ul.email}</td>
                  <td scope="col">
                    <a href="${pageContext.request.contextPath}/editadmin.jsp?userid=${ul.userID}" class="btn btn-outline-danger btn-sm border-0">修改</a>
                    <a href="${pageContext.request.contextPath}/DeleteUserServlet?userid=${ul.userID}"
                       onclick="return del()" class="btn btn-outline-danger btn-sm border-0">删除</a>
                  </td>
                </tr>
            </c:forEach>


          </tbody>
        </table>
        <!-- 分页 -->
        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>