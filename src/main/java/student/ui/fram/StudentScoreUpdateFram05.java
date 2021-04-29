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
import student.dto.StudentScore;
import student.service.StudentDataService;
import student.ui.panel.AddStudentPicPanel;
import student.ui.panel.UpdateStudentScorePanel;
import student.ui.panel.ViewStudentPicPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StudentScoreUpdateFram05 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUpdate;
	private StudentDataService service;
	private UpdateStudentScorePanel pUpdate;////////////성적패널 하나 만들었다. 해당 패널에서 정의해놓은 메서드 setitem 쓸거당
	private ViewStudentPicPanel pPic;
	private StudentData pic = new StudentData();
	private JButton btnClear;


	public StudentScoreUpdateFram05() {
		service = new StudentDataService();
		initialize();
		
	}
	public void setItem(StudentData item) { 
		pUpdate.setItem(item); ////////////////////// 해당 패널에서 정의해놓은 메서드 setitem 쓸거당
		pPic.setItem(item);
	
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 741, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("학생 성적수정");
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pPic = new ViewStudentPicPanel();
		BorderLayout bl_pPic = (BorderLayout) pPic.getLayout();
		bl_pPic.setVgap(10);
		contentPane.add(pPic, BorderLayout.WEST);
		
		pUpdate = new UpdateStudentScorePanel(); ///////////////////////여기를 updatestdscorePanel 하나 따로 만들어서 모프하기~! 기존에 와꾸만 짠거는 기능 안들어가있으니까 add 복사해서 수정하기
		contentPane.add(pUpdate, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtns.add(btnClear);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) { //수정 버튼을 누르면
		StudentData stdData = pUpdate.getItem();
		stdData.setPic(pPic.getString1());
		StudentScore stdScore = pUpdate.getScore();				//StudentData 객체 받아와서 참조,  pUpdate .getItem하면 입력받은 값을 모두 땡겨온다.(학번기준?)
		service.modifyStudentScore(stdScore);						//수정한거 적용
	//	service.addStudentData(stdData);
		//System.out.println(stdData);
		//pList.loadData();
		pUpdate.clearTf();										//클리어
		JOptionPane.showMessageDialog(null, " 수정되었습니다");
		dispose();
		
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		JOptionPane.showMessageDialog(null,  "취소하셨습니다.");
		dispose();
	}
}
