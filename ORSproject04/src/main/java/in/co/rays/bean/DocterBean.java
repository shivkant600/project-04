package in.co.rays.bean;

import java.util.Date;

public class DocterBean extends BaseBean {

	private String name;
	private Date dob;
	private String mobile;
	private String experties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	public String getexperties() {
		return experties;
	}

	public void setexperties(String experties) {
		this.experties = experties;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return experties;
	}

}
