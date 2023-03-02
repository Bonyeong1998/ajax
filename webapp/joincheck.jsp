<%@page import="com.bbs.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String root=request.getContextPath();
%>
<meta charset="UTF-8">
</head>
<body>
<%
String msg=(String) request.getAttribute("result");
if(msg.length()==14){
	response.sendRedirect("login.do");
} else {
%>	
	<script type="text/javascript">
		alert("<%=msg%>");
		history.back();
	</script>
<%} %>
</body>
</html>