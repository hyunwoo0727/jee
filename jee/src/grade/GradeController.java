/**
 * 
 */
package grade;


import java.util.List;

import javax.swing.JOptionPane;

import member.MemberService;
import member.MemberServiceImpl;

/**
 * @date   : 2016. 6. 8.
 * @author : HyunWoo Lee
 * @file   : Avg.java 
 * @story  : exam 임 
*/
public class GradeController {
	
	public static void main(String[] args) {
		GradeService gdService = GradeServiceImpl.getInstance();
		MemberService mService = MemberServiceImpl.getInstance();
		String id = "";
		String[] exam = null;
		while (true) {
			switch (JOptionPane.showInputDialog("1.추가 2.수정 3.삭제 4.전체조회 5.학점을 포함한 시험내역 조회(SEQ) 6.시퀀스 조회(ID로)7.응시생수 0.종료")) {
			case "1":
				// id , 점수4개 입력,날짜입력
				id = JOptionPane.showInputDialog("ID입력");
				if(mService.findById(id)==null){
					JOptionPane.showMessageDialog(null, "아이디가 없습니다");
					break;
				}
				exam = JOptionPane.showInputDialog("JAVA,SQL,HTML,JAVASCRIPT,시험일(2016-05) 입력").split(",");
				GradeBean gdBean = new GradeBean(id, exam[4], exam[0], exam[1], exam[2], exam[3]);
				JOptionPane.showMessageDialog(null, gdService.insert(gdBean));
				break;
			case "2": // 바꾸려는 과목 , 점수 , seq 필요 
				exam = JOptionPane.showInputDialog("바꾸려는 과목명,점수,seq번호 입력").split(",");
				JOptionPane.showMessageDialog(null, gdService.update(exam));
				break;
			case "3":
				JOptionPane.showMessageDialog(null, gdService.delete(JOptionPane.showInputDialog("삭제할 SEQ 번호 입력하세요")));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, gdService.list());
				break;
			case "5":
				GradeBean showBean = gdService.findBySeq(JOptionPane.showInputDialog("조회할 SEQ 번호 입력"));
				JOptionPane.showMessageDialog(null, showBean==null?"일치하는 내용이 없습니다":showBean);
				break;
			case "6":
				id = JOptionPane.showInputDialog("검색할 ID");
				List<GradeBean> tempList = gdService.findSeqById(id);
				JOptionPane.showMessageDialog(null,tempList.size()==0?"시험 내역이 없습니다":tempList);
				break;
			case "7":
				JOptionPane.showMessageDialog(null, gdService.count(JOptionPane.showInputDialog("조회할 시험날짜 입력(2016-05)"))+"명");
				break;
			case "0":
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?")==0){
					JOptionPane.showMessageDialog(null, "SYSTEM OFF");
					return;
				}
				break;
			default: break;
			}
		}
		
	}
	
	
}
