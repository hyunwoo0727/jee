/**
 * 
 */
package bank;


public class AccountServiceImp1 implements AccountService {
	// 1.통장개설 2.입금 3.조회 4.출금 5.통장내역 6.해지
	AccountBean acnt;
	
	@Override
	public void openAccout(String name, String id, String pw) {
		acnt = new AccountBean(name,id,pw);
	}
	@Override
	public void deposit(int inputMoney) {
		acnt.setMoney(acnt.getMoney()+inputMoney);
	}
	@Override
	public void findAccount() {
		
	}
	@Override
	public String withDraw(int output) {
		String result = "잔액부족";
		int money = acnt.getMoney();
		if(money >= output){
			acnt.setMoney(money-output);
			return String.valueOf(acnt.getMoney());
		}
		return result;
	}
	@Override
	public String showAccount() {
		return acnt.toString();
	}
	@Override
	public void closeAccount() {
		acnt=null; // GC가 줏어갈거래. 언젠지 모름		
	}
	
	
}
