package grade;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * @date   :2016. 7. 6.
 * @author :HyunWoo Lee
 * @file   :MyJPanel.java
 * @story  :
*/

public class MyJPanel extends JPanel {
	private boolean DEBUG = false;
	GradeService service = GradeServiceImpl.getInstance();
	
	public MyJPanel(){
		super(new GridLayout(1,0));
		
		List<GradeBean> list = service.list();
		JTable table = new JTable();
	}
}
