package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.panel.AddStudentDataPanel;
import student.ui.panel.AddStudentPicPanel;

public class StudentAddFram extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private StudentDataService service;
	private AddStudentDataPanel panel;
	private JButton btnNewButton_1;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public StudentAddFram() {
		service = new StudentDataService();
		initialize();
		
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("세부정보");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		AddStudentPicPanel panel_1 = new AddStudentPicPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		panel = new AddStudentDataPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(this);
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(this);
		panel_2.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		StudentData stdData = panel.getItem();
		service.addStudentData(stdData);
		//pList.loadData();
		panel.clearTf();
		JOptionPane.showMessageDialog(null, stdData + " 추가했습니다.");
		
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		
	}
}
