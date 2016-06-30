package bank;

import java.util.List;
import java.util.Vector;

/**
 * @date   :2016. 6. 27.
 * @author :HyunWoo Lee
 * @file   :BankServiceImple.java
 * @story  :
*/

public class BankServiceImpl implements BankService{
	private List<AccountBean> accountList;
	
	public BankServiceImpl() {
		// TODO Auto-generated constructor stub
		accountList = new Vector<AccountBean>();
	}
	@Override
	public void openAccount(AccountBean accountBean) {
		accountList.add(accountBean);
	}
	@Override
	public List<AccountBean> AccountList() {
		return accountList;
	}
	@Override
	public AccountBean findByAccountNO(String accoutNo) {
		AccountBean acBean = null;
		for (AccountBean accountBean : accountList) {
			if(accountBean.getAccount()==Integer.parseInt(accoutNo)){
				return accountBean;
			}
		}
		return acBean;
	}
	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> tempList = new Vector<AccountBean>();
		for (AccountBean accountBean : accountList) {
			if(accountBean.getName().equals(name)){
				tempList.add(accountBean);
			}
		}	
		return tempList;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return accountList.size();
	}
	@Override
	public String updateAccount(AccountBean accountBean) {
		AccountBean aBean = findByAccountNO(String.valueOf(accountBean.getAccount()));
		if(aBean!=null){
			aBean.setPw(accountBean.getPw());
			return "변경 완료";
		}
		return "비밀번호가 일치하지 않습니다";
	}
	@Override
	public String closeAccount(String accountNo) {
		AccountBean aBean = findByAccountNO(accountNo);
		if(aBean!=null){
			accountList.remove(aBean);
			return "삭제 성공";
		}
		return "찾는 계좌가 없습니다";
	}
}
