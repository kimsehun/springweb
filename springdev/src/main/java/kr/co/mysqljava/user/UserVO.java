package kr.co.mysqljava.user;

import java.io.Serializable;

public class UserVO implements Serializable {
	private int uNumber;
	private String uId;
	private String uPass;
	private String uEmail;
	private String uAdress;
	private String uDate;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuAdress() {
		return uAdress;
	}
	public void setuAdress(String uAdress) {
		this.uAdress = uAdress;
	}
	
	public int getuNumber() {
		return uNumber;
	}
	public void setuNumber(int uNumber) {
		this.uNumber = uNumber;
	}
	public String getuDate() {
		return uDate;
	}
	public void setuDate(String uDate) {
		this.uDate = uDate;
	}
	@Override
	public String toString() {
		return "UserVO [uNumber=" + uNumber + ", uId=" + uId + ", uPass="
				+ uPass + ", uEmail=" + uEmail + ", uAdress=" + uAdress
				+ ", uDate=" + uDate + "]";
	}

}
