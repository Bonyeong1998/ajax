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

@WebServlet("/ajax/my")
public class MyAjax extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
	      resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Credentials", "true");
		String writer= (String) req.getSession().getAttribute("nickname");
		System.out.println(writer);
		PrintWriter out = resp.getWriter();
		BoardDao dao;
		List<BoardDto> list=null;
		try {
			dao=new BoardDao();
			list = dao.myList(writer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(BoardDto bean : list) {
			out.print("<tr>");
			out.print("<td>"+bean.getIdx()+"</td>");
			out.print("<th><a href=\""+req.getContextPath()+"/detail.do?idx="+bean.getIdx()+"\">"+bean.getTitle()+"</a></th>");
			out.print("<td>"+bean.getRegdate()+"</td>");
			out.print("</tr>");
		}
		out.flush();
		out.close();
	}
}
