package pojo;

import java.util.Date;

// 新闻详情
public class NewsDetail {
	private int id;// 编号
	private int categoryId;// 类别编号
	private String title;// 新闻标题
	private String summary;// 新闻简介
	private String content;// 新闻内容
	private String picPath;// 图片路径
	private String author;// 作者
	private Date createDate;// 创建时间
	private Date modifyDate;// 修改时间

	public NewsDetail() {
		super();
	}

	public NewsDetail(int id, int categoryId, String title, String summary, String content, String picPath,
			String author, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.picPath = picPath;
		this.author = author;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
