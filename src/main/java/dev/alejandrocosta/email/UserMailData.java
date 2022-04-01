package dev.alejandrocosta.email;

public class UserMailData {

	private String userMailAddress;
	private String userMailPassword;
	
	public UserMailData(String userMailAddress, String userMailPassword) {
		this.userMailAddress = userMailAddress;
		this.userMailPassword = userMailPassword;
	}

	public String getUserMailAddress() {
		return userMailAddress;
	}

	public String getUserMailPassword() {
		return userMailPassword;
	}
	
}
