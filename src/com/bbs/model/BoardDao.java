package com.bbs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BoardDao {
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
	
	public void deleteBbs(int idx) throws SQLException {
		String sql="delete from board where idx=?";
		
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public void saveBbs(String writer, String title, String content) throws SQLException {
		String sql="insert into board(writer, title, content) values(?,?,?)";
		
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public void editBbs(int idx, String title, String content) throws SQLException {
		String sql="UPDATE board SET title=?, content=? where idx=?";
		
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
		} finally {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
	
	public BoardDto showOne(int idx) throws SQLException{
		String sql="select * from board where idx=?";
		BoardDto bean=new BoardDto();
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean.setIdx(rs.getInt("idx"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setRegdate(rs.getDate("regdate"));
			}
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			} catch (SQLException e) {
			}
		}
		return bean;
	}
	
	public List<BoardDto> getList() throws SQLException{
		String sql="select * from board";
		List<BoardDto> list=new ArrayList<BoardDto>();
		try {
			getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				BoardDto bean=new BoardDto();
				bean.setIdx(rs.getInt("idx"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setRegdate(rs.getDate("regdate"));
				list.add(bean);
			}
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();				
			} catch (SQLException e) {
			}
		}
		return list;
	}
	
	public List<BoardDto> myList(String nickname) throws SQLException{
		String sql="select * from board where writer=?";
		List<BoardDto> list=new ArrayList<BoardDto>();
		try {
			getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bean=new BoardDto();
				bean.setIdx(rs.getInt("idx"));
				bean.setContent(rs.getString("content"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setRegdate(rs.getDate("regdate"));
				list.add(bean);
			}
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			} catch (SQLException e) {
			}
		}
		return list;
	}
}
