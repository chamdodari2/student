package student.ui.fram; //상세정보 수정하기 UI

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.panel.AddStudentPicPanel;
import student.ui.panel.UpdateStudentDataPanel;

@SuppressWarnings("serial")
public class StudentDataUpdateFram03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUpdate;
	private StudentDataService service;
	private UpdateStudentDataPanel pUpdate;
	private JButton btnClear;
	private AddStudentPicPanel pPic;
	private StudentData pic = new StudentData();
	
	
	


	public StudentDataUpdateFram03() {
		service = new StudentDataService();
		initialize();
	}
		
	
	
	public void setItem(StudentData item) {
		pUpdate.setItem(item); //////////////////////
		pPic.setItem(item);
		
	}
	public void setItem2(StudentData item) {
		pPic.setItem(item); //////////////////////
	System.out.println(pPic);
		
	}
//    public void setvalue(StudentData pic) {//////////////////StudentData 에 생성해놓은 pic 가져옴
//    	pPic.setvalue(pic);
//    	System.out.println("pPic>>>>>"+pic);
//
//	}
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("학생 상세정보 조회 / 수정");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pPic = new AddStudentPicPanel();
	//	pPic.getLblPic();
		System.out.println("pPic.getLblPic();"+ pPic.getLblPic());
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
		stdData.setPic(pPic.getString1());
		service.modifyStudentData(stdData);						//수정한거 적용
		
		//pList.loadData();
	////	pUpdate.clearTf();
	//	System.out.println(pic);
		//stdData.setPic(pic);
	//	stdData.getPic();
	//	System.out.println("get pic>>>> "+stdData.getPic());

		JOptionPane.showMessageDialog(null, stdData + "  수정했습니다.");
		dispose();
		
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		JOptionPane.showMessageDialog(null,  "취소하셨습니다.");
		dispose();
	}
}
