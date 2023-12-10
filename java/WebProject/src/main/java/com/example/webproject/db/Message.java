package com.example.webproject.db;

public class Message {
	private String info;
	private int code;
	private Object data;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Message(String info, int code, Object data) {
		super();
		this.info = info;
		this.code = code;
		this.data = data;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String json() {
		return this.toString();
	}

}
