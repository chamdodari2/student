package student.ui.fram; //상세정보 수정하기 UI

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.panel.AddStudentPicPanel;
import student.ui.panel.UpdateStudentDataPanel;

public class StudentDataUpdateFram03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUpdate;
	private StudentDataService service;
	private UpdateStudentDataPanel pUpdate;
	private JButton btnClear;



	public StudentDataUpdateFram03() {
		service = new StudentDataService();
		initialize();
		
	}
	public void setItem(StudentData item) {
		pUpdate.setItem(item); //////////////////////	
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("세부정보");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		AddStudentPicPanel pPic = new AddStudentPicPanel();
		contentPane.add(pPic, BorderLayout.WEST);
		
		pUpdate = new UpdateStudentDataPanel();
		contentPane.add(pUpdate, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 15));
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		btnClear.setFont(new Font("굴림", Font.BOLD, 15));
		pBtns.add(btnClear);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedbtnUpdate(e);
		}
	}
	protected void actionPerformedbtnUpdate(ActionEvent e) { //수정 버튼을 누르면
		StudentData stdData = pUpdate.getItem();				//StudentData 객체 받아와서 참조,  pUpdate .getItem하면 입력받은 값을 모두 땡겨온다.(학번기준?)
		service.modifyStudentData(stdData);						//수정한거 적용
		//pList.loadData();
	//	pUpdate.clearTf();										//클리어
		JOptionPane.showMessageDialog(null, stdData + "  수정했습니다.");
		dispose();
		
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		JOptionPane.showMessageDialog(null,  "취소하셨습니다.");
		dispose();
	}
}
