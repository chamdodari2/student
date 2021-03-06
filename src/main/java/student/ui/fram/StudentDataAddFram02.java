package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.exception.InvalidChechException;
import student.ui.exception.SqlConstraintException;
import student.ui.panel.AddStudentDataPanel;
import student.ui.panel.AddStudentPicPanel;

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
		setBounds(700, 400, 693, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("νμ μΆκ°");
		contentPane.setLayout(new BorderLayout(-10, 10));

		pPic = new AddStudentPicPanel();
		BorderLayout bl_pPic = (BorderLayout) pPic.getLayout();
		bl_pPic.setVgap(10);
		contentPane.add(pPic, BorderLayout.WEST);

		panel = new AddStudentDataPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		btnAdd = new JButton("μ μ₯");
		btnAdd.setFont(new Font("κ΅΄λ¦Ό", Font.BOLD, 15));
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);

		btnClear = new JButton("μ·¨μ");
		btnClear.setFont(new Font("κ΅΄λ¦Ό", Font.BOLD, 15));
		btnClear.addActionListener(this);
		panel_2.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {  /////////////////// μ¬κΈ°μ tryν΄μ£Όλ©΄ λ²νΌ λλΌμλ§μ μ΅μμ μ‘μμ£Όλκ±°μ¬μ   throwκ³΅λ°±μ΄μ‘΄μ¬ν©λλ€  λ°μλμ  λ©μΈμ§λ€μ΄μ΄λ‘κ·Έ λ³΄μ¬μ£ΌκΈ° κ°λ₯!
		try {
			if (e.getSource() == btnAdd) {
				actionPerformedbtnAdd(e);
			}
			if (e.getSource() == btnClear) {
				actionPerformedbtnClear(e);
			}
		} catch (InvalidChechException | SqlConstraintException e1) {
//			JOptionPane.showMessageDialog(null, "κ³΅λ°±μ΄ μ‘΄μ¬ν©λλ€.");
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	protected void actionPerformedbtnAdd(ActionEvent e) {
		StudentData stdData = null;
		stdData = panel.getItem();
		stdData.setPic(pPic.getString1());
		service.addStudentData(stdData);
		service.addStudentScore(stdData.getStdNo());
		// pList.loadData();
		panel.clearTf();
		JOptionPane.showMessageDialog(null," μΆκ°νμ΅λλ€.");

	}

	protected void actionPerformedbtnClear(ActionEvent e) { //μ·¨μλ²νΌ λλ₯΄λ©΄
		JOptionPane.showMessageDialog(null, "μ·¨μνμ¨μ΅λλ€");
		dispose();
		
	
	}
}
