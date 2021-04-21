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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StudentScoreUpdateFram05 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUpdate;
	private StudentDataService service;
	private UpdateStudentScorePanel pUpdate;////////////성적패널 하나 만들었다. 해당 패널에서 정의해놓은 메서드 setitem 쓸거당



	public StudentScoreUpdateFram05() {
		service = new StudentDataService();
		initialize();
		
	}
	public void setItem(StudentData item) { 
		pUpdate.setItem(item); ////////////////////// 해당 패널에서 정의해놓은 메서드 setitem 쓸거당
	
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
		
		pUpdate = new UpdateStudentScorePanel(); ///////////////////////여기를 updatestdscorePanel 하나 따로 만들어서 모프하기~! 기존에 와꾸만 짠거는 기능 안들어가있으니까 add 복사해서 수정하기
		contentPane.add(pUpdate, BorderLayout.CENTER);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		JButton btnClear = new JButton("취소");
		pBtns.add(btnClear);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("성적 수정");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 35));
		panel.add(label);
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) { //수정 버튼을 누르면
		
		StudentScore stdScore = pUpdate.getScore();				//StudentData 객체 받아와서 참조,  pUpdate .getItem하면 입력받은 값을 모두 땡겨온다.(학번기준?)
		service.modifyStudentScore(stdScore);						//수정한거 적용
		//pList.loadData();
		pUpdate.clearTf();										//클리어
		JOptionPane.showMessageDialog(null, stdScore + "  수정했습니다.");
		dispose();
		
	}
}
