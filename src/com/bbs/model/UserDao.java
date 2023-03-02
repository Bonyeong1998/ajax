package com.bbs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class UserDao {
	java.util.logging.Logger log=Logger.getGlobal();
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getConnection() {
		String url="jdbc:mysql://localhost:3306/webpage";
		String user="scott";
		String password="tiger";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn==null || conn.isClosed())
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String signUp(String id, String pw, String nickname) throws SQLException {
		String msg="";
		UserDto bean=userCheck(id, nickname);
		if(bean.getCheck()==1) {
			msg="이미 존재하는 아이디 또는 닉네임입니다.";
		} else {
			String sql="insert into user values(?,?,?)";
			try {
				getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, nickname);
				pstmt.executeUpdate();
				msg="회원가입이 완료되었습니다.";
			} finally {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}
		}
		return msg;
	}
	
	public UserDto userCheck(String id, String nickname) throws SQLException {
		String sql="select exists(select * from user where id=? or nickname=?)as 'check'";
		UserDto bean=new UserDto();
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickname);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setCheck(rs.getInt("check"));
			}
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return bean;
	}
	
	public UserDto userLogin(String id, String pw) throws SQLException{
		String sql="select exists(select * from user where id=? and pw=?)as 'check'";
		UserDto bean=new UserDto();
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setCheck(rs.getInt(1));
			}
			if(bean.getCheck()==1) {
				String sql2="select id, nickname from user where id=? and pw=?";
				rs.close();
				pstmt.close();
				conn.close();
				getConnection();
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					bean.setId(rs.getString("id"));
					bean.setNickname(rs.getString("nickname"));
				}
			}
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		return bean;
	}
	
}
