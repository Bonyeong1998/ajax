package com.bbs.util;

import java.sql.SQLException;
import java.util.List;

import com.bbs.model.BoardDao;
import com.bbs.model.BoardDto;
import com.bbs.model.UserDao;
import com.bbs.model.UserDto;

public class TestMain {
	public static void main(String[] args) throws SQLException {
		BoardDao dao = new BoardDao();
		String aa="카페인줘";
		List<BoardDto> list=dao.myList(aa);
		for(BoardDto bean:list) {
			System.out.println(bean.toString());
		}
	}
}
