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

public class JoinCheckController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg="";
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String pwcheck=req.getParameter("pwcheck");
		String nickname=req.getParameter("nickname");
		System.out.println(nickname);
		if(!pw.equals(pwcheck)) {
			msg="패스워드가 일치하지 않습니다.";
			req.setAttribute("result", msg);
			RequestDispatcher rd=req.getRequestDispatcher("joincheck.jsp");
			rd.forward(req, resp);
			return;
		}
		if(!id.isEmpty()&&!pw.isEmpty()&&!pwcheck.isEmpty()&&!nickname.isEmpty()) {
			UserDao dao=new UserDao();
			try{
				msg=dao.signUp(id, pw, nickname);
				req.setAttribute("result", msg);
			} catch (SQLException e){
			}
			RequestDispatcher rd=req.getRequestDispatcher("joincheck.jsp");
			rd.forward(req, resp);
			return;
		} else {
			msg="빈칸이 존재합니다.";
			req.setAttribute("result", msg);
			RequestDispatcher rd=req.getRequestDispatcher("joincheck.jsp");
			rd.forward(req, resp);
			return;
		}
	}
}
