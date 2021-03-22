package student.ui.panel;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.dto.GradeConvertion;
import student.dto.StudentData;

public class StudentMgnBtn01Top extends JPanel {
	private JPanel pDayNight;
	private JLabel lblDayNight;
	private JComboBox<StudentData> cBDayNight;  //3.dto클래스 참조
	private JPanel pDept;
	private JLabel lblStdDept;
	private JComboBox<String> cBStdDept;   //1. String타입으로 받기로함
	private JComboBox<GradeConvertion> cBGrade;
	private JLabel cBStateName;
	private JPanel pStateName;
	private JComboBox<String> cBStateName_1;
	private JPanel pSelectBtn;
	private JButton btnSelectBtn;
	private JPanel pGrade;
	private JLabel lblGrade;   
	//2. db에서 데이터 가져오기  - 배열로 하는 방법도 있지만 ArrayList로 
	ArrayList<String> DayNightShift =  new ArrayList<>();
	ArrayList<String> GradeConvertion =  new ArrayList<>();
	

	public StudentMgnBtn01Top() {

		initialize();
		
		
		
	}

	private void initialize() {
		setLayout(new GridLayout(0, 5, -30, 0));
		
		pDayNight = new JPanel();
		pDayNight.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pDayNight);
		pDayNight.setLayout(new GridLayout(0, 2, 20, 0));
		
		lblDayNight = new JLabel("주야구분");
		lblDayNight.setFont(new Font("굴림", Font.BOLD, 12));
		lblDayNight.setHorizontalAlignment(SwingConstants.CENTER);
		pDayNight.add(lblDayNight);
		
		cBDayNight = new JComboBox<>();
		cBDayNight.setFont(new Font("굴림", Font.BOLD, 12));
		cBDayNight.setModel(new DefaultComboBoxModel(new String[] {"주간"}));
		pDayNight.add(cBDayNight);
		
		pDept = new JPanel();
		pDept.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pDept);
		pDept.setLayout(new GridLayout(0, 2, 20, 0));
		
		lblStdDept = new JLabel("학과");
		lblStdDept.setFont(new Font("굴림", Font.BOLD, 12));
		lblStdDept.setHorizontalAlignment(SwingConstants.CENTER);
		pDept.add(lblStdDept);
		
		cBStdDept = new JComboBox<>();
		cBStdDept.setModel(new DefaultComboBoxModel(new String[] {"컴퓨터정보"}));
		pDept.add(cBStdDept);
		
		pGrade = new JPanel();
		pGrade.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pGrade);
		pGrade.setLayout(new GridLayout(0, 2, 20, 0));
		
		lblGrade = new JLabel("학년");
		lblGrade.setFont(new Font("굴림", Font.BOLD, 12));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);
		
		cBGrade = new JComboBox<>();
		cBGrade.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		pGrade.add(cBGrade);
		
		pStateName = new JPanel();
		pStateName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStateName);
		pStateName.setLayout(new GridLayout(0, 2, 20, 0));
		
		cBStateName = new JLabel("학적구분");
		cBStateName.setFont(new Font("굴림", Font.BOLD, 12));
		cBStateName.setHorizontalAlignment(SwingConstants.CENTER);
		pStateName.add(cBStateName);
		
		cBStateName_1 = new JComboBox<>();
		cBStateName_1.setModel(new DefaultComboBoxModel(new String[] {"재학"}));
		pStateName.add(cBStateName_1);
		
		pSelectBtn = new JPanel();
		pSelectBtn.setBorder(new EmptyBorder(0, 40, 0, 40));
		add(pSelectBtn);
		pSelectBtn.setLayout(new GridLayout(0, 1, 100, 0));
		
		btnSelectBtn = new JButton("조회");
		btnSelectBtn.setFont(new Font("굴림", Font.BOLD, 12));
		pSelectBtn.add(btnSelectBtn);
	}

}
