<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String root=request.getContextPath();
%>
  <link rel="stylesheet" href="css/join.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  <script type="text/javascript" src="<%=root%>/js/jquery-1.12.4.min.js"></script>
  <title>로그인</title>
  <script type="text/javascript">
  	$('.forgot>a').click(function(){
  		history.back();
  	});
  </script>
</head>
<body>
  <div class="main">
    <p class="sign">회원 가입</p>
    <form class="login" method="post" action="<%=root%>/joincheck.do">
      <input class="un " type="text"  placeholder="id" name="id">
      <input class="un " type="text"  placeholder="nickname" name="nickname">
      <input class="pass" type="password"  placeholder="pwd" name="pw">
      <input class="pass" type="password"  placeholder="pwd check" name="pwcheck">
      <button class="submit" type="submit">확인</button>
      <p class="forgot" ><a href="<%=root%>/">취소</a></p>
    </div>
</body>
</html>