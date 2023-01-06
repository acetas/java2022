package kodlamaIoOdev.entities;

public class Member extends Person {

	private String email;
	private String password;
	private boolean isSubscribe;
	private String[] myCourseList;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSubscribe() {
		return isSubscribe;
	}

	public void setSubscribe(boolean isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String[] getMyCourseList() {
		return myCourseList;
	}

	public void setMyCourseList(String[] myCourseList) {
		this.myCourseList = myCourseList;
	}

}
