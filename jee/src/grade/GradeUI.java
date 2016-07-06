package grade;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bank2.AccountServiceImp;

/**
 * @date   :2016. 7. 6.
 * @author :HyunWoo Lee
 * @file   :GradeUI.java
 * @story  :
*/

public class GradeUI extends JFrame{
	
	private JPanel wrapper_panel,flow_panel;
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("static-access")
	public GradeUI() {
		this.setLayout();
		this.setResizable(false);//this abort resize
		this.setLocationRelativeTo(null);//this load at center of screen
		this.setSize(700, 300);//this set size width, height
		this.setVisible(true);//this set visible mode (false - non-visible)
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);//x btn of this is end of this
	}
	
	@SuppressWarnings("unchecked")
	private void setLayout() {
		wrapper_panel = new JPanel();
		wrapper_panel.setSize(690, 300);
		flow_panel = new JPanel(new FlowLayout());
		wrapper_panel.add(new JList(AccountServiceImp.getInstance().list().toArray()));
		JScrollPane jsp = new JScrollPane(wrapper_panel);
		this.add(jsp);
	}
}
