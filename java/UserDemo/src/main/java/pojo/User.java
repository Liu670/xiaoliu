package pojo;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import util.Constants;

public class User implements HttpSessionBindingListener {
	private String userName;
	private String password;

	// 在session绑定时调用
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		Constants.userCount++;
	}

	// 从session删除时调用
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		Constants.userCount--;
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}

}
