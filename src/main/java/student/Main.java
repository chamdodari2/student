package student;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.ui.fram.StudentMgnBtn01;
import student.ui.fram.StudentMgnBtn02;
import student.ui.fram.StudentMgnBtn03;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		setTitle("학생관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("학생 관리 프로그램");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnNewButton = new JButton("학적/학생 관리");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		button = new JButton("학생 조회 관리");
		button.addActionListener(this);
		button.setFont(new Font("굴림", Font.BOLD, 25));
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		button_1 = new JButton("   성적 관리   ");
		button_1.addActionListener(this);
		button_1.setFont(new Font("굴림", Font.BOLD, 25));
		panel_3.add(button_1);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		button_2 = new JButton("      종료      ");
		button_2.addActionListener(this);
		button_2.setFont(new Font("굴림", Font.BOLD, 25));
		panel_4.add(button_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_2) {
			actionPerformedButton_2(e);
		}
		if (e.getSource() == button_1) {
			actionPerformedButton_1(e);
		}
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {// 버튼1 (학적/학생관리)
		StudentMgnBtn01 frame = new StudentMgnBtn01();
		frame.setVisible(true);
		
		
		
	}
	protected void actionPerformedButton(ActionEvent e) {//버튼2 (학생 조회관리)
		StudentMgnBtn02 frame = new StudentMgnBtn02();
		frame.setVisible(true);
	}
	protected void actionPerformedButton_1(ActionEvent e) {  //버튼3 (성적관리)
		StudentMgnBtn03 frame = new StudentMgnBtn03();
		frame.setVisible(true);
	}
	protected void actionPerformedButton_2(ActionEvent e) {	//버튼4 (종료)
		
	}
}
