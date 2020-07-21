package com.fragrance.web.entity;

import java.sql.Date;

public class Reply {
	private int id;
	private int itemNums;
	private String writerName;
	private String content;
	private Date regDate;

	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int id, int itemNums, String writerName, String content, Date regDate) {
		this.id = id;
		this.itemNums = itemNums;
		this.writerName = writerName;
		this.content = content;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", itemNums=" + itemNums + ", writerName=" + writerName + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNums() {
		return itemNums;
	}

	public void setItemNums(int itemNums) {
		this.itemNums = itemNums;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
