/**
 * 
 */
package bank2;

import java.util.List;
import javax.swing.JOptionPane;

import grade.GradeUI;
import member.MemberService;
import member.MemberServiceImpl;

/**
 * @date   : 2016. 6. 15.
 * @author : HyunWoo Lee
 * @file   : BankContoller.java 
 * @story  : 
*/
public class AccountContoller {
	public static void main(String[] args) {
		MemberService memService = MemberServiceImpl.getInstance();
		AccountService accService = AccountServiceImp.getInstance();
		
		while (true) {
			switch (JOptionPane.showInputDialog("1.통장개설 2.입금 3.출금 4.수정(비번) 5.해지 6.조회(전체) \n "
					+ "============================================================================================\n"
					+ "7.조회(계좌번호) 8.조회(이름) 9.총 계좌수 10.로긴 0.종료")) {
			case "10":
				memService.map();
				break;
			case "1":
				String id = JOptionPane.showInputDialog("개설할 아이디");
				if(memService.findById(id)==null){
					JOptionPane.showMessageDialog(null, "아이디 가입부터 해주세요");
					break;
				};
				JOptionPane.showMessageDialog(null, accService.openAccount(id)); 
				break;
			case "2":
				AccountMemberBean accBean = accService.findByAccountNo(JOptionPane.showInputDialog("계좌번호 입력"));
				if(accBean==null){
					JOptionPane.showMessageDialog(null, "없는 계좌입니다");
					break;
				}
				accBean.setMoney(JOptionPane.showInputDialog("입금액"));
				JOptionPane.showMessageDialog(null, accService.deposit(accBean)); 
				break;
			case "3":
				AccountMemberBean withBean = accService.findByAccountNo(JOptionPane.showInputDialog("계좌번호 입력"));
				if(withBean==null){
					JOptionPane.showMessageDialog(null, "없는 계좌입니다");
					break;
				}
				withBean.setMoney(JOptionPane.showInputDialog("출금액"));
				JOptionPane.showMessageDialog(null, accService.withdraw(withBean));
				break;
			case "4":
				String[] sData = JOptionPane.showInputDialog("계좌번호,현재 비밀번호 입력").split(",");
				AccountMemberBean uptBean = accService.findByAccountNo(sData[0]);
				if(uptBean==null){
					JOptionPane.showMessageDialog(null, "없는 계좌입니다");
					break;
				}
				
				if(!uptBean.getPw().equals(sData[1])){
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다");
					break;
				}
				uptBean.setPw(JOptionPane.showInputDialog("바꿀 비밀 번호"));
				JOptionPane.showMessageDialog(null,accService.updateAccount(uptBean));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, accService.closeAccount(JOptionPane.showInputDialog("계좌 번호 입력")));
				break;
			case "6":
				new GradeUI();
				break;
			case "7":
				JOptionPane.showMessageDialog(null, accService.findByAccountNo(JOptionPane.showInputDialog("계좌번호 입력")));
				break;
			case "8":
				List<AccountMemberBean> tempList = (List<AccountMemberBean>) accService.findBy(JOptionPane.showInputDialog("이름 입력"));
				JOptionPane.showMessageDialog(null, tempList.isEmpty()?"검색된 내용이 없습니다":tempList);
				break;
			case "9":
				JOptionPane.showMessageDialog(null, accService.count()+"개의 계좌가 있습니다");
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
