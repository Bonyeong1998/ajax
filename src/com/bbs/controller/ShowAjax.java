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

@WebServlet("/ajax/show")
public class ShowAjax extends HttpServlet {

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
		out.print("<tr><td class=\"titles\">제목</td><td>"+bean.getTitle()+"</td></tr>");
		out.print("<tr><td class=\"contents\">내용</td><td><textarea name=\"content\" readonly>"+bean.getContent()+"</textarea></td></tr>");
		out.print("<tr><td class=\"back\" colspan=\"2\"><button type=\"button\" onClick=\"history.go(-1)\">돌아가기</button><td></tr>");
		out.flush();
		out.close();
	}
}
