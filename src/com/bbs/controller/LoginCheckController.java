package com.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.UserDao;
import com.bbs.model.UserDto;

public class LoginCheckController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		UserDao dao=new UserDao();
		try {
			UserDto bean=dao.userLogin(id, pw);
			req.setAttribute("info", bean);
		} catch (SQLException e) {
		}
		RequestDispatcher rd=req.getRequestDispatcher("lgcheck.jsp");
		rd.forward(req, resp);
	}
}
