<%@page import="java.util.List"%>
<%@page import="com.bbs.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("nickname")==null){
	response.sendRedirect("login.do");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String root=request.getContextPath();
%>
<link rel="stylesheet" href="css/menu.css">
<style type="text/css">
* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.container {
  width: 1100px;
  margin: 0 auto;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 40px 0;
}

.page-title {
  margin-bottom: 60px;
}
.page-title h3 {
  font-size: 28px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

.board-table {
  font-size: 13px;
  width: 100%;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}

.board-table a {
  color: #333;
  display: inline-block;
  line-height: 1.4;
  word-break: break-all;
  vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}

.board-table td {
  padding: 14px 0;
}

.board-table td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
}

.board-table input {
  width: 700px;
}
.board-table textarea {
  width: 700px;
  height: 500px;
}
.board-table button{
      cursor: pointer;
        border-radius: 5em;
        color: #fff;
        background: #91A891;
        border: 0;
        padding-left: 40px;
        padding-right: 40px;
        padding-bottom: 10px;
        padding-top: 10px;
        font-family: 'Ubuntu', sans-serif;
        font-size: 13px;
        box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
    }
</style>
<script type="text/javascript" src="<%=root %>/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
var urlParams=new URL(location.href).searchParams;
var idx=urlParams.get('idx');
$(document).ready(function() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/bbs/ajax/edit',
		data : {"idx" : idx},
		success : function(result) {
			$('#edit').html(result);
		}
	});
});
</script>
</head>
<body>
	<div class="container">
		<div id="menu">
			<ul>
		    	<li><a href="<%=root%>/index.do">게시판</a></li>
		    	<li><a href="<%=root%>/write.do">작성하기</a></li>
		    	<li><a class="active" href="<%=root%>/my.do">내 작성글</a></li>
		    	<li><a href="<%=root%>/logout.do">로그아웃</a></li>
		    </ul>
		</div>
		<div id="content">
		<section class="notice">
		  	<div class="page-title">
		        <div class="container">
		            <h3>게시글 수정</h3>
		        </div>
		    </div>
		  <!-- board list area -->
		    <div id="board-list">
		        <div class="container" id="edit">
		        	
		        </div>
		    </div>
		</section>
		</div>
		<div id="footer">
			Copyright by bitacademy co.ltd. All rights reserved.
		</div>
	</div>
</body>
</html>