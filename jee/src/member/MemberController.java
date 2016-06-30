/**
 * 
 */
package member;

import javax.swing.JOptionPane;

/**
 * @date   : 2016. 6. 16.
 * @author : HyunWoo Lee
 * @file   : SchoolController.java 
 * @story  : 
*/
public class MemberController {
	public static void main(String[] args) {
		// ssn 아이디 비번 이름 
		MemberService stuService = new MemberServiceImpl();
		
		while (true) {
			switch (JOptionPane.showInputDialog("1.등록 2.조회 3.수정 4.삭제 0.종료")) {
			case "1":
				String[] spec = JOptionPane.showInputDialog("이름,아이디,비밀번호,주민등록번호(ex:870727-1)").split(",");
				stuService.registStudent(spec[0], spec[1], spec[2], spec[3]);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, stuService.findStudent());
				break;
			case "3":
				String nowPw = JOptionPane.showInputDialog("현재 비밀번호");
				if(stuService.checkPassword(nowPw)){
					stuService.updateStudent(JOptionPane.showInputDialog("바꿀 비밀번호"));
					JOptionPane.showMessageDialog(null, "변경 완료");
				}else{
					JOptionPane.showMessageDialog(null, "비번이 틀려요");
				}
				break;
			case "4":
				stuService.deleteStudent();
				break;
			case "0":
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?")==0){
					JOptionPane.showMessageDialog(null, "SYSTEM OFF");
					return;
				}
				break;
			default:
				break;
			}
		}
		
	
	}
}
