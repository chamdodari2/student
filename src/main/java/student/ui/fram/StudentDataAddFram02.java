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
import student.ui.exception.InvalidChechException;
import student.ui.panel.AddStudentDataPanel;
import student.ui.panel.AddStudentPicPanel;
import java.awt.Font;

public class StudentDataAddFram02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private StudentDataService service;
	private AddStudentDataPanel panel;
	private JButton btnClear;
	private AddStudentPicPanel pPic;
	private StudentData pic = new StudentData();

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

	public StudentDataAddFram02() {
		service = new StudentDataService();
		initialize();

	}
	
	public void setItem(StudentData item) {
		
	//	pPic.setItem(item);
		
	}
	

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("학생 추가");
		contentPane.setLayout(new BorderLayout(-10, 10));

		pPic = new AddStudentPicPanel();
		BorderLayout bl_pPic = (BorderLayout) pPic.getLayout();
		bl_pPic.setVgap(10);
		contentPane.add(pPic, BorderLayout.WEST);

		panel = new AddStudentDataPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		btnAdd = new JButton("저장");
		btnAdd.setFont(new Font("굴림", Font.BOLD, 15));
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);

		btnClear = new JButton("취소");
		btnClear.setFont(new Font("굴림", Font.BOLD, 15));
		btnClear.addActionListener(this);
		panel_2.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {  /////////////////// 여기서 try해주면 버튼 누라자마자 익셉션 잡아주는거여서   throw공백이존재합니다  발생대신 메세지다이어로그 보여주기 가능!
		try {
			if (e.getSource() == btnAdd) {
				actionPerformedbtnAdd(e);
			}
			if (e.getSource() == btnClear) {
				actionPerformedbtnClear(e);
			}
		} catch (InvalidChechException e1) {
			JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		}
	}

	protected void actionPerformedbtnAdd(ActionEvent e) {
		StudentData stdData = panel.getItem();
		stdData.setPic(pPic.getString1());
		service.addStudentData(stdData);
		service.addStudentScore(stdData.getStdNo());
		// pList.loadData();
		panel.clearTf();
		JOptionPane.showMessageDialog(null, stdData + " 추가했습니다.");

	}

	protected void actionPerformedbtnClear(ActionEvent e) { //취소버튼 누르면
		JOptionPane.showMessageDialog(null, "취소하셨습니다");
		dispose();
		
	
	}
}
