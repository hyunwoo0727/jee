/**
 * 
 */
package bank;

/**
 * @date   : 2016. 6. 20.
 * @author : HyunWoo Lee
 * @file   : AccountService.java 
 * @story  : 
*/
public class AccountService2{
	// 1.통장개설 2.입금 3.조회 4.출금 5.통장내역
	AccountBean acnt;
	// 1.개설
	public void openAccout(String name,String id,String pw){
		acnt = new AccountBean(name,id,pw);
	}
	// 2.입금
	public void deposit(int inputMoney){
		acnt.setMoney(acnt.getMoney()+inputMoney);
	}
	// 3.조회
	public void findAccount(){
		
	}
	// 4.출금
	public String withDraw(int output){
		String result = "잔액부족";
		int money = acnt.getMoney();
		if(money >= output){
			acnt.setMoney(money-output);
			return String.valueOf(acnt.getMoney());
		}
		return result;
	}
	//5.통장내역
	public String showAccount(){
		return acnt.toString();
	}
	//6.해지
	public void closeAccount(){
		acnt=null; // GC가 줏어갈거래. 언젠지 모름 
	}
}
