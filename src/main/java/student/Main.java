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

import student.ui.fram.StudentDataSearchFram01;
import student.ui.fram.StudentScoreSearchFram04;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Main frame = new Main();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
	}
	private void initialize() {
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
		
		btnNewButton = new JButton("학생 조회 / 관리");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		button = new JButton("성적 조회 / 관리");
		button.addActionListener(this);
		button.setFont(new Font("굴림", Font.BOLD, 25));
		panel_2.add(button);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {// 버튼1 (학적/학생관리)
		StudentDataSearchFram01 frame = new StudentDataSearchFram01() {
					
		};
		frame.setVisible(true);
		
		
		
	}
	protected void actionPerformedButton(ActionEvent e) {
		StudentScoreSearchFram04 frame = new StudentScoreSearchFram04();
		frame.setVisible(true);
	}
}
