package com.fragrance.web.entity;

public class Celeb {
	 private int titleNums;
	   private String imgBanner;
	   private String imgDetail;
	   private String title;
	   private String writerId;
	   private String regDate;
	   private String content;
	   private int like;
	   private int hit;
	   private String celeb;
	   private int itemNums;
	   
	   
	   public Celeb() {
		// TODO Auto-generated constructor stub
	}


	public Celeb(int titleNums, String imgBanner, String imgDetail, String title, String writerId, String regDate,
			String content, int like, int hit, String celeb, int itemNums) {
		super();
		this.titleNums = titleNums;
		this.imgBanner = imgBanner;
		this.imgDetail = imgDetail;
		this.title = title;
		this.writerId = writerId;
		this.regDate = regDate;
		this.content = content;
		this.like = like;
		this.hit = hit;
		this.celeb = celeb;
		this.itemNums = itemNums;
	}


	public int getTitleNums() {
		return titleNums;
	}


	public void setTitleNums(int titleNums) {
		this.titleNums = titleNums;
	}


	public String getImgBanner() {
		return imgBanner;
	}


	public void setImgBanner(String imgBanner) {
		this.imgBanner = imgBanner;
	}


	public String getImgDetail() {
		return imgDetail;
	}


	public void setImgDetail(String imgDetail) {
		this.imgDetail = imgDetail;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriterId() {
		return writerId;
	}


	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getCeleb() {
		return celeb;
	}


	public void setCeleb(String celeb) {
		this.celeb = celeb;
	}


	public int getItemNums() {
		return itemNums;
	}


	public void setItemNums(int itemNums) {
		this.itemNums = itemNums;
	}


	@Override
	public String toString() {
		return "Celeb [titleNums=" + titleNums + ", imgBanner=" + imgBanner + ", imgDetail=" + imgDetail + ", title="
				+ title + ", writerId=" + writerId + ", regDate=" + regDate + ", content=" + content + ", like=" + like
				+ ", hit=" + hit + ", celeb=" + celeb + ", itemNums=" + itemNums + "]";
	}
	   
	
	  

}
