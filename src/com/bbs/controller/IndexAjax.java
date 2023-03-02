package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BoardDao;
import com.bbs.model.BoardDto;

@WebServlet("/ajax/index")
public class IndexAjax extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		List<BoardDto> list=null;
		try {
			BoardDao dao=new BoardDao();
			list = dao.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(BoardDto bean : list) {
			out.print("<tr>");
			out.print("<td>"+bean.getIdx()+"</td>");
			out.print("<th><a href=\""+req.getContextPath()+"/show.do?idx="+bean.getIdx()+"\">"+bean.getTitle()+"</a></th>");
			out.print("<td>"+bean.getRegdate()+"</td>");
			out.print("</tr>");
		}
		out.flush();
		out.close();
	}
}
