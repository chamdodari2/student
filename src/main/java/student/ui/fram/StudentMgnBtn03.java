package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.ui.panel.StudentMgnBtn03Center;
import student.ui.panel.StudentMgnBtn03Top;

public class StudentMgnBtn03 extends JFrame {

	private JPanel contentPane;

	public StudentMgnBtn03() {
		initialize();
	}
	private void initialize() {
		setTitle("학생 조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 400, 742, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTItle = new JLabel("성적관리");
		lblTItle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTItle.setFont(new Font("굴림", Font.BOLD, 35));
		pTop.add(lblTItle);
		
		StudentMgnBtn03Top pSelect = new StudentMgnBtn03Top();
		pTop.add(pSelect, BorderLayout.SOUTH);
		
		StudentMgnBtn03Center pCenter = new StudentMgnBtn03Center();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pBtnHome = new JPanel();
		contentPane.add(pBtnHome, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		pBtnHome.add(btnNewButton);
	}

}
