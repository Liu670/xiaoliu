package pojo;

import java.util.Date;

// 新闻类别表
public class NewsCategory {
	private int id; // 编号
	private String name;// 类别名
	private Date createDate;// 创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public NewsCategory() {
		super();
	}

	public NewsCategory(int id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

}
