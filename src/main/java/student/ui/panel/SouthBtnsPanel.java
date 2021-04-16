package student.ui.panel;

import javax.swing.JPanel;

import student.ui.fram.StudentAddFram;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SouthBtnsPanel extends JPanel implements ActionListener {
	private JButton btnAddStd;


	public SouthBtnsPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		btnAddStd = new JButton("학생추가");
		btnAddStd.addActionListener(this);
		btnAddStd.setFont(new Font("굴림", Font.BOLD, 20));
		panel_1.add(btnAddStd);
		
		JButton btnNewButton_3 = new JButton("메인으로");
		btnNewButton_3.setFont(new Font("굴림", Font.BOLD, 20));
		panel_1.add(btnNewButton_3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddStd) {
			actionPerformedBtnAddStd(e);
		}
	}
	protected void actionPerformedBtnAddStd(ActionEvent e) {
		StudentAddFram frame = new StudentAddFram();
		frame.setVisible(true);
		
	}
}
