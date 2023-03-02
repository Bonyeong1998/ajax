package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BoardDao;
import com.bbs.model.BoardDto;

@WebServlet("/ajax/edit")
public class EditAjax extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		int idx=Integer.parseInt(req.getParameter("idx"));
		PrintWriter out = resp.getWriter();
		BoardDto bean=null;
		try {
			BoardDao dao=new BoardDao();
			bean=dao.showOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("<form action=\""+req.getContextPath()+"/edit.do?idx="+idx+"\" method=\"post\">");
		out.print("<table class=\"board-table\">");
		out.print("<tr><td>제목</td><td><input type=\"text\" name=\"title\" value=\""+bean.getTitle()+"\"></td></tr>");
		out.print("<tr><td>내용</td><td><textarea name=\"content\">"+bean.getContent()+"</textarea></td></tr>");
		out.print("<tr><td colspan=\"2\"><button type=\"submit\">수정하기</button><button type=\"reset\" onClick=\"history.go(-1)\">돌아가기</button></td>");
		out.print("</table></form>");
		out.flush();
		out.close();
	}
}
