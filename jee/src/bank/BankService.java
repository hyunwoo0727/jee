package bank;

import java.util.List;

/**
 * @date :2016. 6. 27.
 * @author :HyunWoo Lee
 * @file :BankService.java
 * @story :
 */

public interface BankService {
	// 1. CREATE : 1개설 
	public abstract void openAccount(AccountBean accountBean);
	// 2. READ 모든 계좌(list) 
	public List<AccountBean> AccountList();
	// 3. READ (계좌번호로 조회)
	public AccountBean findByAccountNO(String accoutNo);
	// 4. READ(이름)
	public List<AccountBean> findByName(String name);
	// 5. READ(전체통장수)
	public int count();
	// 7. UPDATE : 사용자 요청으로 비번만 변경
	public String updateAccount(AccountBean accountBean);
	// 8. DELETE 해지
	public String closeAccount(String accountNo);
}
