package student.ui.fram; //상세정보 수정하기 UI

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

public class StudentUpdateFram extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private StudentDataService service;
	private AddStudentDataPanel panel;
	
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


	public StudentUpdateFram() {
		service = new StudentDataService();
		initialize();
		
	}
	public void setItem(StudentData item) {
		panel.setItem(item); //////////////////////	
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
		
		btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(this);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_2.add(btnNewButton_1);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		StudentData stdData = panel.getItem();
		service.modifyStudentData(stdData);
		//pList.loadData();
		panel.clearTf();
		JOptionPane.showMessageDialog(null, stdData + " 수정했습니다.");
		dispose();
		
	}
}
