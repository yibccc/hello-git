<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
    String num=(String)application.getAttribute("num");
    if(num==null){
        //第一次访问
        application.setAttribute("num", "1");
    }else{
        int num_ = Integer.parseInt(num);
        num_ +=1;
        application.setAttribute("num", String.valueOf(num_));
    }

%>
<body>
    <script src="js/jquery.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
</body>
    <p align="right">网站访问次数: <%=application.getAttribute("num") %></p>
</html>