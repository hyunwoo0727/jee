/**
 * 
 */
package bank;

import global.Constants;

/**
 * @date   : 2016. 6. 16.
 * @author : HyunWoo Lee
 * @file   : Account.java 
 * @story  : 
*/
public class AccountBean {
	
		private String name;
		private String id;
		private String pw;
		private int    money;
		private int    accountNo;
	
		public AccountBean() {
			this.accountNo = (int) (Math.random()*1000000+100001);
			if(this.accountNo > 1000000){
				this.accountNo -= 100000;
			}
			this.money = 0;
		}
		public AccountBean(String name,String id,String pw) {
			
			this.money = 0;
			this.id = id;
			this.pw = pw;
			this.name = name;
		}
		public void setName(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setId(String id){
			this.id = id;
		}
		public String getId() {
			return id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public int getAccount() {
			return accountNo;
		}
		public void setAccount(String accountNo){
			this.accountNo = Integer.parseInt(accountNo);
		}
		@Override
		public String toString() {
			return Constants.BANK_NAME + "[이름=" + name 
					+ ", 아이디=" + id 
					+ ", 비밀번호=" + pw 
					+ ", 잔액=" + money 
					+ ", 계좌번호=" + accountNo + "]\n";
		}
}
