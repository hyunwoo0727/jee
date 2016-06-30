/**
 * 
 */
package bank;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * @date   : 2016. 6. 15.
 * @author : HyunWoo Lee
 * @file   : BankContoller.java 
 * @story  : 
*/
public class BankContoller {
	public static void main(String[] args) {
		AccountServiceImp1 acsv = new AccountServiceImp1();
		BankService bsv = new BankServiceImpl();
		AccountBean accountBean = null;
		List<AccountBean>  list = null;
		while (true) {
			switch (JOptionPane.showInputDialog("1.통장개설 2.입금 3.조회 4.출금 5.통장내역 6.계좌삭제 \n "
					+ "============================================================================================\n"
					+ " 11.통장개설(관리자)"
					+ "12.전체조회 13.계좌번호로 검색 14.이름으로 검색 15.총 계좌수 16.비밀번호 변경 17.계좌삭제 0.종료")) {
			case "1":
				String[] spec = JOptionPane.showInputDialog("예금주,ID,PW").split(",");
				acsv.openAccout(spec[0],spec[1],spec[2]);
				break;
			case "2":
				if(acsv.acnt==null){
					JOptionPane.showMessageDialog(null, "통장부터 만드세요");
					break;
				}			
				acsv.deposit(Integer.parseInt(JOptionPane.showInputDialog("입금액?")));
				break;
			case "3":
				if(acsv.acnt==null){
					JOptionPane.showMessageDialog(null, "통장부터 만드세요");
					break;
				}
				break;
			case "4":
				if(acsv.acnt==null){
					JOptionPane.showMessageDialog(null, "통장부터 만드세요");
					break;
				}
				JOptionPane.showMessageDialog(null,acsv.withDraw(Integer.parseInt(JOptionPane.showInputDialog("출금액 ? : "))));
				break;
			case "5":
				if(acsv.acnt==null){
					JOptionPane.showMessageDialog(null, "통장부터 만드세요");
					break;
				}
				JOptionPane.showMessageDialog(null, acsv.showAccount());
				break;
			case "6":
				acsv.closeAccount();
				break;
			case "11":
				spec = JOptionPane.showInputDialog("이름,아이디,비밀번호 입력").split(",");
				accountBean = new AccountBean(spec[0],spec[1],spec[2]);
				bsv.openAccount(accountBean);
				break;
			case "12":
				list = bsv.AccountList();
				JOptionPane.showMessageDialog(null, list); 
				break;
			case "13":
				accountBean = bsv.findByAccountNO(JOptionPane.showInputDialog("계좌번호 입력"));
				JOptionPane.showMessageDialog(null, accountBean==null ? "계좌가 없습니다" : accountBean.toString());
				break;
			case "14":
				list = bsv.findByName(JOptionPane.showInputDialog("이름"));
				JOptionPane.showMessageDialog(null, list.isEmpty() ? "일치하는 계좌가 없습니다" : list);
				break;
			case "15":
				JOptionPane.showMessageDialog(null, "총 통장수 : " + bsv.count());
				break;
			case "16":
				spec = JOptionPane.showInputDialog("계좌번호,새로운 pw 입력").split(",");
				accountBean = new AccountBean();
				accountBean.setAccount(spec[0]);
				accountBean.setPw(spec[1]);
				JOptionPane.showMessageDialog(null, bsv.updateAccount(accountBean)); 
				break;
			case "17":
				JOptionPane.showMessageDialog(null, bsv.closeAccount(JOptionPane.showInputDialog("계좌번호")));
				break;
			default:
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?")==0){
					JOptionPane.showMessageDialog(null, "SYSTEM OFF");
					return;
				}
				break;
			}
		}
	}
}
