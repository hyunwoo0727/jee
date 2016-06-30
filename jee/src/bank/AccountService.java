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
public interface AccountService {
	// 1.통장개설 2.입금 3.조회 4.출금 5.통장내역
		// 1.개설
		public abstract void openAccout(String name,String id,String pw);
		// 2.입금
		public void deposit(int inputMoney);
		// 3.조회
		public void findAccount();
		// 4.출금
		public String withDraw(int output);
		//5.통장내역
		public String showAccount();
		//6.해지
		public void closeAccount();
}
