package student.ui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import student.dto.StdDepartment;
import student.dto.StudentData;
import student.dto.StudentScore;
import student.service.StudentDataService;
import student.ui.content.AbstractContentPanel;
import student.ui.exception.InvalidChechException;

@SuppressWarnings("serial")
public class UpdateStudentScorePanel extends AbstractContentPanel<StudentData> {
	private JTextField tfStdNo;
	private JTextField tfName;
	private StudentDataService service;
	private JTextField tfSubject1;
	private JTextField tfSubject2;
	private JTextField tfSubject3;
	private JComboBox cbGrade;
	private JComboBox<StdDepartment> cbStdDept;
	private JComboBox cbDayNightShift;

	public UpdateStudentScorePanel() {
		service = new StudentDataService();
		initialize();
		addDataCbStdDept(); // 1. 학과콤보박스 메서드!
		// //////////////////////////////////////////////////////////////////////3번
		
		
	

	}
	

	
	private void addDataCbStdDept() { // 2 . 콤보박스안에 값을 넣어준다//////////////////////////////////////////////////////4번
		List<StdDepartment> stdDeptList = service.showStdDepartments(); // 학과 담아서
		System.out.println(stdDeptList);
		DefaultComboBoxModel<StdDepartment> stdDeptModel = new DefaultComboBoxModel<>(new Vector<>(stdDeptList));
		cbStdDept.setModel(stdDeptModel);
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pLeft = new JPanel();
		panel.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		pLeft.add(panel_4);
		
		JLabel lblStdDept = new JLabel("학     과");
		lblStdDept.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdDept.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblStdDept);
		
		cbStdDept = new JComboBox<StdDepartment>();
		cbStdDept.setEnabled(false);
		panel_4.add(cbStdDept);
		
		JPanel panel_7 = new JPanel();
		pLeft.add(panel_7);
		
		JLabel lblGrade = new JLabel("학     년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("굴림", Font.BOLD, 15));
		panel_7.add(lblGrade);
		
		cbGrade = new JComboBox<>();
		cbGrade.setEnabled(false);
		cbGrade.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		panel_7.add(cbGrade);
		
		JPanel panel_8 = new JPanel();
		pLeft.add(panel_8);
		
		JLabel lblDayNightShift = new JLabel("주야구분");
		lblDayNightShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayNightShift.setFont(new Font("굴림", Font.BOLD, 15));
		panel_8.add(lblDayNightShift);
		
		cbDayNightShift = new JComboBox<>();
		cbDayNightShift.setEnabled(false);
		cbDayNightShift.setModel(new DefaultComboBoxModel(new String[] {"", "주간", "야간"}));
		panel_8.add(cbDayNightShift);
		
		JPanel panel_2 = new JPanel();
		pLeft.add(panel_2);
		
		JLabel lblStdNo = new JLabel("학     번");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(lblStdNo);
		
		tfStdNo = new JTextField();
		tfStdNo.setEditable(false);
		panel_2.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		pLeft.add(panel_3);
		
		JLabel lblName = new JLabel("이     름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(lblName);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		panel_3.add(tfName);
		tfName.setColumns(10);
		
		JPanel pRight = new JPanel();
		panel.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pRight.add(panel_1);
		
		JLabel lblSubject1 = new JLabel("1 과  목");
		lblSubject1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubject1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_1.add(lblSubject1);
		
		tfSubject1 = new JTextField();
		tfSubject1.setColumns(10);
		panel_1.add(tfSubject1);
		
		JPanel panel_5 = new JPanel();
		pRight.add(panel_5);
		
		JLabel lblSubject2 = new JLabel("1 과  목");
		lblSubject2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubject2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_5.add(lblSubject2);
		
		tfSubject2 = new JTextField();
		tfSubject2.setColumns(10);
		panel_5.add(tfSubject2);
		
		JPanel panel_6 = new JPanel();
		pRight.add(panel_6);
		
		JLabel lblSubject3 = new JLabel("1 과  목");
		lblSubject3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubject3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(lblSubject3);
		
		tfSubject3 = new JTextField();
		tfSubject3.setColumns(10);
		panel_6.add(tfSubject3);
	}

	@Override
	public void setItem(StudentData item) {  //여기서 적어주면 프레임에서 땡겨쓴당 과목 아직 안들어가있음
		System.out.println(item.getStdDepartment());
		tfStdNo.setText(item.getStdNo() + "");
		tfName.setText(item.getStdName());
	//	tfIdNo.setText(item.getIdNo());
	//tfHpNo.setText(item.getHpNo());
		cbStdDept.setSelectedItem(item.getStdDepartment());
		cbGrade.setSelectedIndex(item.getGrade());
	//	cbStdState.setSelectedItem(item.getStdState());
	//	cbMilitaryState.setSelectedItem(item.getMilitaryState());
		cbDayNightShift.setSelectedItem(item.getDayNightShift());
		tfSubject1.setText(item.getSubject1() +"");
		tfSubject2.setText(item.getSubject2() +"");
		tfSubject3.setText(item.getSubject3() +"");
		
		
	}

	@Override
	public StudentData getItem() {
//		stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift
		validCheck();
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
		String stdName = tfName.getText().trim();
		StdDepartment stdDepartment = (StdDepartment) cbStdDept.getSelectedItem();
	//	int subject1 =tfSubject1.getText().trim();
		int grade = cbGrade.getSelectedIndex();
		String  dayNightShift =(String) cbDayNightShift.getSelectedItem(); //////////여기에 과목 1,2,3 cnrkgownrl!!
		
		int subject1 = Integer.parseInt(tfSubject1.getText().trim());
		int subject2 = Integer.parseInt(tfSubject2.getText().trim());
		int subject3 = Integer.parseInt(tfSubject3.getText().trim());
		return new StudentData(stdNo, stdName, stdDepartment, grade, dayNightShift, subject1, subject2, subject3);

	}
	
	

	@Override
	public void validCheck() {
		if (tfStdNo.getText().contentEquals("") || tfName.getText().equals("")
				||cbStdDept.getSelectedIndex() <= 0
				||cbGrade.getSelectedIndex() <= 0
				|| tfSubject1.getText().contentEquals("")
				|| tfSubject2.getText().contentEquals("")
				|| tfSubject3.getText().contentEquals("")
				||cbDayNightShift.getSelectedIndex() <=0 ) {
			throw new InvalidChechException();
		}
		
	}

	@Override
	public void clearTf() {
		tfStdNo.setText("");
		tfName.setText("");
		tfSubject1.setText("");
		tfSubject2.setText("");
		tfSubject3.setText("");
		cbDayNightShift.setSelectedIndex(0);
		cbGrade.setSelectedIndex(0);	
		cbStdDept.setSelectedIndex(0);

		
	}



	public StudentScore getScore() {
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
		int subject1 = Integer.parseInt(tfSubject1.getText().trim());
		int subject2 = Integer.parseInt(tfSubject2.getText().trim());
		int subject3 = Integer.parseInt(tfSubject3.getText().trim());
		return new StudentScore( new StudentData(stdNo),subject1, subject2, subject3);
	}

}
