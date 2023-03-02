package com.bbs.model;

import java.sql.Date;

public class BoardDto {
	int idx;
	String writer, title, content;
	Date regdate;
	
	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	
	
//	idx    INT              NOT NULL    AUTO_INCREMENT, 
//    writer      VARCHAR(50)      NOT NULL, 
//    title       VARCHAR(50)      NOT NULL, 
//    content     VARCHAR(1000)    NOT NULL, 
//    regdate     DATETIME   NOT NULL DEFAULT now(), 
}
