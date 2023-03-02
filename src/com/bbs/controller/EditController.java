package com.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BoardDao;
import com.bbs.model.BoardDto;
@WebServlet(value={"/edit.do"})
public class EditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int idx=Integer.parseInt(req.getParameter("idx"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		BoardDao dao=new BoardDao();
		try {
			dao.editBbs(idx, title, content);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("detail.do?idx="+idx);
	}
}
