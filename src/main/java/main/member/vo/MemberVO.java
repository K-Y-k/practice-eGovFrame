package main.member.vo;

public class MemberVO {
	
	private String userid;
	private String pass;
	private String name;
	private String birth;
	private String phone;
	private String gender;
	private String zipcode;
	private String address;
	private String reg;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", pass=" + pass + ", name=" + name + ", birth=" + birth + ", phone="
				+ phone + ", gender=" + gender + ", zipcode=" + zipcode + ", address=" + address + ", reg=" + reg + "]";
	}
	
	
}
