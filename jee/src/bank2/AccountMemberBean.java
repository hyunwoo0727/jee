	package bank2;


/**
 * @date   :2016. 7. 6.
 * @author :HyunWoo Lee
 * @file   :AccountMemberBean.java
 * @story  :
*/

public class AccountMemberBean {
	private String id,pw,name,regDate,ssn,birth,gender;
	private int money,accountNo,age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setMoney(String money){
		this.money = Integer.parseInt(money);
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "계좌 [아이디 : " + id + ", 계좌번호 : " + accountNo + ", 이름 : " + name + ", 잔액 : "+money+" 원 "
				+ "생년월일 : "+ birth+"]";
	}
}
