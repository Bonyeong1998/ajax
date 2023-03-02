<%@page import="com.bbs.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String root=request.getContextPath();
%>
<meta charset="UTF-8">
</head>
<body>
<%
UserDto bean=(UserDto) request.getAttribute("info");
if(bean.getCheck()==1){
%>
	<script type="text/javascript">
		alert("로그인 성공");
	</script>
<%
	session.setAttribute("id", bean.getId());
	session.setAttribute("nickname", bean.getNickname());
	response.sendRedirect("index.do");
%>	
<%} else{%>
	<script type="text/javascript">
		alert("아이디 또는 패스워드를 확인해주세요");
		history.back();
	</script>
<%} %>
</body>
</html>