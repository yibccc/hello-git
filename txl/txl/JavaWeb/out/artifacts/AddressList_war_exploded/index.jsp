<%@page import="User.Domain.Friend"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="User.Domain.Friend" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <script src="https://cdn.bootcdn.net/ajax/libs/bootbox.js/5.4.0/bootbox.js"></script>
    <script type="text/javascript">
      function del(){
        if(!confirm("确认要删除？")){
          window.event.returnValue = false;
        }
      }
      function search() {
        if(!confirm("确认要查询？")){
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
          <a class="nav-link" data-toggle="tab" href="#userlist">通讯录管理</a>
        </li>
      </ul>
      <div class="tab-content" id="myTabContent">        
        <div class="tab-pane fade show active" id="userlist" role="tabpanel" aria-labelledby="profile-tab">
          <div id="searchfriends">
            <div class="card">
              <h5 class="card-header">通讯录查询</h5>
              <div class="card-body">
                <form action="${pageContext.request.contextPath}/IndexServlet" method="post" onsubmit="return search()">
                  <div class="form-group row">
                    <label for="friendname" class="col-1 col-form-label">姓名</label>
                    <div class="col-5">
                      <input type="text" class="form-control" id="friendname" name ="friendname">
                    </div>
                    <label for="phoneid" class="col-2 col-form-label">电话号码</label>
                    <div class="col-4">
                      <input type="text" class="form-control" id="phoneid" name="phoneid">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="qq" class="col-1 col-form-label">QQ</label>
                    <div class="col-5">
                      <input type="text" class="form-control" id="qq" name="qq">
                    </div>
                    <label for="email" class="col-2 col-form-label">电子邮箱</label>
                    <div class="col-4">
                      <input type="text" class="form-control" id="email" name="email">
                    </div>
                  </div>                  
                  <div class="form-group rowright">
                    <button type="submit" class="btn btn-primary mr-3">查询</button>
                  </div>
                </form>
              </div>
            </div>
          </div>          
          
          <div>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">朋友ID</th>
                  <th scope="col">朋友姓名</th>
                  <th scope="col">电话号码</th>
                  <th scope="col">qq</th>
                  <th scope="col">电子邮箱</th>
                  <th scope="col">创建时间</th>
                  <th scope="col">操作</th>
                </tr>
              </thead>
              <tbody>
                <%
                      @SuppressWarnings("unchecked")
                      ArrayList<Friend> friendlist = (ArrayList<Friend>) request.getSession().getAttribute("friendlist");
                      if(friendlist != null){
                        for (int i=0; i<friendlist.size(); i++) {
                %>
                        <tr>
                  				<td><%=friendlist.get(i).getFriendID() %></td>
                                <td><%=friendlist.get(i).getFriendName() %></td>
                                <td><%=friendlist.get(i).getPhoneID() %></td>
                                <td><%=friendlist.get(i).getQQ() %></td>
                                <td><%=friendlist.get(i).getEmail() %></td>
                                <td><%=friendlist.get(i).getCreateDate() %></td>
                                <td>
			                      <a href="${pageContext.request.contextPath}/editfriends.jsp?friend=<%=friendlist.get(i).getFriendID()%>" class="btn btn-outline-danger btn-sm border-0">修改</a>
			                      <a href="${pageContext.request.contextPath}/DeleteFriendServlet?friendid=<%=friendlist.get(i).getFriendID()%>"
                                     onclick="return del()" class="btn btn-outline-danger btn-sm border-0">删除</a>
			                    </td>
                        </tr>
                  <%
                        }
                      }
                  %>

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