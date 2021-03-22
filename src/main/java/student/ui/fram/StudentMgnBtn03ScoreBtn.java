package student.ui.fram;

import java.awt.BorderLayout;
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

import student.ui.panel.StudentMgnBtn03ScoreBtnCenter;

public class StudentMgnBtn03ScoreBtn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;

	public StudentMgnBtn03ScoreBtn() {
		initialize();
	}
	private void initialize() {
		setTitle("성적수정");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 400, 568, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("성적 수정");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblNewLabel);
		
		JPanel pBtnHome = new JPanel();
		contentPane.add(pBtnHome, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		pBtnHome.add(btnNewButton);
		
		JButton button = new JButton("취소");
		button.setFont(new Font("굴림", Font.BOLD, 25));
		pBtnHome.add(button);
		
		StudentMgnBtn03ScoreBtnCenter pCenter = new StudentMgnBtn03ScoreBtnCenter();
		contentPane.add(pCenter, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
