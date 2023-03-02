<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String root=request.getContextPath();
%>
  <link rel="stylesheet" href="css/login.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  <script type="text/javascript" src="<%=root%>/js/jquery-1.12.4.min.js"></script>
  <title>로그인</title>
</head>
<body>
  <div class="main">
    <p class="sign">로그인</p>
    <form class="login" method="post" action="<%=root%>/lgcheck.do">
      <input class="un " type="text"  placeholder="id" name="id" id="id">
      <input class="pass" type="password"  placeholder="password" name="pw" id="pw">
      <button class="submit" type="submit">로그인</button>
      <p class="forgot" ><a href="<%=root%>/join.do">회원가입</p>
    </div>
    
</body>
</html>