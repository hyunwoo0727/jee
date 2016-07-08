package bank2;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :BankUI.java
 * @story  :
*/

public class BankUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel wrapper_panel;
	@SuppressWarnings("static-access")
	public BankUI() {
		this.setLayout();
		this.setResizable(false);//this abort resize
		this.setLocationRelativeTo(null);//this load at center of screen
		this.setSize(700, 300);//this set size width, height
		this.setVisible(true);//this set visible mode (false - non-visible)
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);//x btn of this is end of this
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setLayout() {
		wrapper_panel = new JPanel();
		wrapper_panel.setSize(690, 300);
		wrapper_panel.add(new JList(AccountServiceImp.getInstance().list().toArray()));
		JScrollPane jsp = new JScrollPane(wrapper_panel);
		this.add(jsp);
	}
}
