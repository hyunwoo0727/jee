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
		GradeService gdService = new GradeServiceImpl();
		
		while (true) {
			switch (JOptionPane.showInputDialog("1.학점 0.종료")) {
			case "1":
				String[] studentSpec = JOptionPane.showInputDialog("이름,국어점수,영어점수,수학점수").split(",");
				gdService.registStudent(studentSpec);
				JOptionPane.showMessageDialog(null, gdService.getResult());
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
