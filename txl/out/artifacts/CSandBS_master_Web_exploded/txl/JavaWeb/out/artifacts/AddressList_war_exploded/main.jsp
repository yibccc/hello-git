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
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/main.js"></script>
    <title>个人通信录</title>
  </head>
  <body>
	<%@ include file="header.jsp" %>
    <div class="page">
      <header class="page_header">
        <h1>个人通讯录</h1>
      </header>
      <div class="cards-holder">
        <div class="card">
          <header class="card_header" data-background="">
            <h2>注册功能</h2>
          </header>
          <section class="card_content">
            <h2>通讯录用户注册</h2>
            <p>可以通过手机、邮箱、等方式注册。</p>
          </section>
        </div>

        <div class="card">
          <header class="card_header" data-background="">
            <h2>修改功能</h2>
          </header>
          <section class="card_content">
            <h2>修改通讯录成员、修改用户</h2>
            <p>可以用户指定信息、并实时返回数据供使用者查看。</p>
          </section>
        </div>

        <div class="card">
          <header class="card_header" data-background="">
            <h2>增加功能</h2>
          </header>
          <section class="card_content">
            <h2>增加通讯录成员</h2>
            <p>可以给登陆的用户为自己通讯录新增成员、并填写对应信息。</p>
          </section>
        </div>

        <div class="card">
          <header class="card_header" data-background="">
            <h2>查询功能</h2>
          </header>
          <section class="card_content">
            <h2>查询通讯录成员</h2>
            <p>可以根据条件查询并获得通讯录成员信息。</p>
          </section>
        </div>

        <div class="card">
          <header class="card_header" data-background="">
            <h2>管理员功能</h2>
          </header>
          <section class="card_content">
            <h2>管理用户</h2>
            <p>可以修改与删除用户的基本信息。</p>
          </section>
        </div>

      </div>
    </div>
  </body>
</html>