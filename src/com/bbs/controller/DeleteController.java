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

@WebServlet(value={"/delete.do"})
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idx=Integer.parseInt(req.getParameter("idx"));
		
		try {
			BoardDao dao=new BoardDao();
			dao.deleteBbs(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("my.do");
	}
}
