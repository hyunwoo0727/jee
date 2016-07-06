/**
 * 
 */
package bank2;

import java.util.List;

/**
 * @date   : 2016. 6. 20.
 * @author : HyunWoo Lee
 * @file   : AccountService.java 
 * @story  : 
*/
public interface AccountService {

	public String openAccount(String id);
	// 1.개설
	// 2.입금
	// 3.출금
	// 4.수정(비번)
	// 5.해지
	// 6.조회(전체)
	// 7.조회(계좌번호)
	// 8.조회(이름)
	// 9.조회(전체통장수)
	public AccountMemberBean findByAccountNo(String accNo);
	public String deposit(AccountMemberBean accBean);
	public List<AccountMemberBean> list();
	public String withdraw(AccountMemberBean withBean);
	public List<AccountMemberBean> findByName(String name);
	public int count();
	public String closeAccount(String accNo);
	
}
