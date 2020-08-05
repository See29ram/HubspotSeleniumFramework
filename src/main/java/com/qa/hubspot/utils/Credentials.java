package com.qa.hubspot.utils;

public class Credentials {

	private String appUserName;
	private String appUserPassWord;

	public Credentials(String appUserName, String appUserPassWord) {

		this.appUserName = appUserName;
		this.appUserPassWord = appUserPassWord;
	}

	public String getAppUserName() {
		return appUserName;
	}

	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}

	public String getAppUserPassWord() {
		return appUserPassWord;
	}

	public void setAppUserPassWord(String appUserPassWord) {
		this.appUserPassWord = appUserPassWord;
	}

}
