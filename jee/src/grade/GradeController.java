/**
 * 
 */
package grade;


import javax.swing.JOptionPane;

/**
 * @date   : 2016. 6. 8.
 * @author : HyunWoo Lee
 * @file   : Avg.java 
 * @story  : exam 임 
*/
public class GradeController {
	
	public static void main(String[] args) {
		GradeService gdService = GradeServiceImpl.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1.추가 2.수정 3.삭제 4.전체조회 5.학점조회 6.시퀀스조회 0.종료")) {
			case "1":
					
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
