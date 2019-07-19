package com.newlecture.web.entity;


import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;
	//private String category;
	
	
	public Notice() {
		
	}
	
//	public Notice(String[] args){
//		this.id = Integer.parseInt(args[0]);
//		this.title = args[1];
//		this.writerId = args[2];
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
//		Date date = null;
//		try {
//			date = dt.parse(args[3]);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		this.regDate = date;
//		this.hit = Integer.parseInt(args[4]);
//	}

	public Notice(int id, String title, String content, String writerId,
			Date regDate, int hit) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
		//this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}


	
	
	
}
