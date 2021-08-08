package ru.rsreu.vkr.datalayer.data;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String login;
	private String password;
	private String email;
	private int userGroup;
	private int isAuthorized;
	private int isBlocked;

	public Users(int id, String login, String password, String email, int userGroup, int isAuthorized, int isBlocked) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.userGroup = userGroup;
		this.isAuthorized = isAuthorized;
		this.isBlocked = isBlocked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(int userGroup) {
		this.userGroup = userGroup;
	}

	public int getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(int isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public int getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(int isBlocked) {
		this.isBlocked = isBlocked;
	}
}
