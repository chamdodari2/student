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

import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.content.AbstractContentPanel;
import student.ui.exception.InvalidChechException;

@SuppressWarnings("serial")
public class AddStudentDataPanel extends AbstractContentPanel<StudentData> {
	private JTextField tfStdNo;
	private JTextField tfName;
	private JTextField tfIdNo;
	private JTextField tfHpNo;
	private JComboBox<StdDepartment> cbStdDept;
	private JComboBox cbGrade;//
	private JComboBox<StdState> cbStdState;
	private JComboBox<MilitaryState> cbMilitaryState;
	private StudentDataService service;
	private JComboBox cbDayNightShift;

	public AddStudentDataPanel() {
		service = new StudentDataService();
		initialize();
		addDataCbStdDept(); // 1. 학과콤보박스 메서드!
		// //////////////////////////////////////////////////////////////////////3번
		addDataCbStdState();
		addDatacbMilitaryStateName();
	

	}
	

	private void addDatacbMilitaryStateName() {
		List<MilitaryState> militaryStateList = service.showMilitaryStates();
		DefaultComboBoxModel<MilitaryState> militaryStateModel = new DefaultComboBoxModel<>(
				new Vector<>(militaryStateList));
		// System.out.println(stdStateList);
		cbMilitaryState.setModel(militaryStateModel);

	}

	private void addDataCbStdState() {
		List<StdState> stdStateList = service.showStdStates();
		DefaultComboBoxModel<StdState> stdStateModel = new DefaultComboBoxModel<>(new Vector<>(stdStateList));
		System.out.println(stdStateList);
		cbStdState.setModel(stdStateModel);
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
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblStdNo = new JLabel("학     번");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(lblStdNo);
		
		tfStdNo = new JTextField();
		panel_2.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblName = new JLabel("이     름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(lblName);
		
		tfName = new JTextField();
		panel_3.add(tfName);
		tfName.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblIdNo = new JLabel("주민번호");
		lblIdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblIdNo);
		
		tfIdNo = new JTextField();
		panel_4.add(tfIdNo);
		tfIdNo.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel lblHpNo = new JLabel(" 연락처 ");
		lblHpNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHpNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_5.add(lblHpNo);
		
		tfHpNo = new JTextField();
		panel_5.add(tfHpNo);
		tfHpNo.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JLabel lblStdDept = new JLabel("학     과");
		lblStdDept.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdDept.setFont(new Font("굴림", Font.BOLD, 15));
		panel_7.add(lblStdDept);
		
		cbStdDept = new JComboBox<>();
		panel_7.add(cbStdDept);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JLabel lblGrade = new JLabel("학     년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("굴림", Font.BOLD, 15));
		panel_8.add(lblGrade);
		
		cbGrade = new JComboBox<>();
		cbGrade.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		panel_8.add(cbGrade);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		JLabel lblDayNightShift = new JLabel("주야구분");
		lblDayNightShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayNightShift.setFont(new Font("굴림", Font.BOLD, 15));
		panel_9.add(lblDayNightShift);
		
		cbDayNightShift = new JComboBox<>();
		cbDayNightShift.setModel(new DefaultComboBoxModel(new String[] {"", "주간", "야간"}));
		panel_9.add(cbDayNightShift);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		JLabel lblStdState = new JLabel("학적상태");
		lblStdState.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdState.setFont(new Font("굴림", Font.BOLD, 15));
		panel_11.add(lblStdState);
		
		cbStdState = new JComboBox<>();
		panel_11.add(cbStdState);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		
		JLabel lblMilitaryState = new JLabel("병역상태");
		lblMilitaryState.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilitaryState.setFont(new Font("굴림", Font.BOLD, 15));
		panel_10.add(lblMilitaryState);
		
		cbMilitaryState = new JComboBox<>();
		panel_10.add(cbMilitaryState);
	}

	@Override
	public void setItem(StudentData item) {

		tfStdNo.setText(item.getStdNo() + "");
		tfName.setText(item.getStdName());
		tfIdNo.setText(item.getIdNo());
		tfHpNo.setText(item.getHpNo());
		cbStdDept.setSelectedItem(item.getStdDepartment());
		cbGrade.setSelectedIndex(item.getGrade());
		cbStdState.setSelectedItem(item.getStdState());
		cbMilitaryState.setSelectedItem(item.getMilitaryState());
		cbDayNightShift.setSelectedItem(item.getDayNightShift());
		
	}

	@Override
	public StudentData getItem() {
//		stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift
		validCheck();
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
		String stdName = tfName.getText().trim();
		StdDepartment stdDepartment = (StdDepartment) cbStdDept.getSelectedItem();
		String idNo =tfIdNo.getText().trim();
		String hpNo =tfHpNo.getText().trim();
		int grade = cbGrade.getSelectedIndex();
		StdState stdState = (StdState) cbStdState.getSelectedItem();
		MilitaryState  militaryState =(MilitaryState) cbMilitaryState.getSelectedItem();
		String  dayNightShift =(String) cbDayNightShift.getSelectedItem();
		
		return new StudentData(stdNo, stdName, stdDepartment, grade, stdState, militaryState, idNo, hpNo, dayNightShift);
	}

	@Override
	public void validCheck() {
		if (tfStdNo.getText().contentEquals("") || tfName.getText().equals("")
				||cbStdDept.getSelectedIndex() <= 0
				||cbGrade.getSelectedIndex() <= 0
				||cbStdState.getSelectedIndex() <= 0
				||cbMilitaryState.getSelectedIndex() <=0
				||cbDayNightShift.getSelectedIndex() <=0 ) {
			throw new InvalidChechException();
		}
		
	}

	@Override
	public void clearTf() {
		tfStdNo.setText("");
		tfName.setText("");
		tfIdNo.setText("");
		tfHpNo.setText("");
		cbDayNightShift.setSelectedIndex(0);
		cbGrade.setSelectedIndex(0);
		cbMilitaryState.setSelectedIndex(0);
		cbStdDept.setSelectedIndex(0);
		cbStdState.setSelectedIndex(0);
		
	}

}
