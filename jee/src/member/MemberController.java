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
		MemberService stuService = MemberServiceImpl.getInstance();
		MemberBean memberBean = new MemberBean();
		String[] spec = null;
		while (true) {
			switch (JOptionPane.showInputDialog(""
					+ "--- 회원이 보는 화면 ---\n"
					+ "1회원가입 2로그인 3.내정보 보기(로긴되있는 상태) 4내정보수정(비번) 5탈퇴 0종료\n"
					+ "--- 관리자 화면 ---\n"
					+ "11회원목록 12검색(ID) 13검색(이름) 14검색(성별) 15회원수 ")) {
			case "1":
				spec = JOptionPane.showInputDialog("이름,아이디,비밀번호,주민등록번호(ex:870727-1)").split(",");
				memberBean = new MemberBean();
				memberBean.setRegDate();
				memberBean.setName(spec[0]);
				memberBean.setId(spec[1]);
				memberBean.setPw(spec[2]);
				memberBean.setSsn(spec[3]);
				JOptionPane.showMessageDialog(null,stuService.regist(memberBean)); 
				break;
			case "2":
				MemberBean loginBean = new MemberBean();
				spec = JOptionPane.showInputDialog("아이디,비밀번호").split(",");
				loginBean.setId(spec[0]);
				loginBean.setPw(spec[1]);
				JOptionPane.showMessageDialog(null, stuService.login(loginBean));
				break;
			case "3":
				MemberBean session = stuService.getSession();
				JOptionPane.showMessageDialog(null, session==null?"로그인해주셈":session);
				break;
			case "4":
				memberBean.setPw(JOptionPane.showInputDialog("변경할 비밀번호"));
				JOptionPane.showMessageDialog(null, stuService.update(memberBean));
				break;
			case "5":
//				JOptionPane.showMessageDialog(null, stuService.delete(JOptionPane.showInputDialog("탈퇴할 아이디")));
				break;
			case "11":
				JOptionPane.showMessageDialog(null, stuService.list());
				break;
			case "12":
				MemberBean resultBean = stuService.findById(JOptionPane.showInputDialog("찾을 ID"));
				JOptionPane.showMessageDialog(null, resultBean==null?"아이디가 없습니다":resultBean);
				break;
			case "13":
				JOptionPane.showMessageDialog(null, stuService.findBy(JOptionPane.showInputDialog("이름검색")));
				break;
			case "14":
				break;
			case "15":
				JOptionPane.showMessageDialog(null, stuService.count() + "명");
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
