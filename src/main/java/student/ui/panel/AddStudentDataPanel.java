package student.ui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.awt.ComponentOrientation;

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
		
		JPanel pLeft = new JPanel();
		panel.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		flowLayout.setVgap(20);
		pLeft.add(panel_2);
		
		JLabel lblStdNo = new JLabel("학     번");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(lblStdNo);
		
		tfStdNo = new JTextField();
		tfStdNo.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(tfStdNo);
		tfStdNo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(20);
		pLeft.add(panel_3);
		
		JLabel lblName = new JLabel("이     름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(lblName);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(tfName);
		tfName.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setHgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(20);
		pLeft.add(panel_4);
		
		JLabel lblIdNo = new JLabel("주민번호");
		lblIdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(lblIdNo);
		
		tfIdNo = new JTextField();
		tfIdNo.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(tfIdNo);
		tfIdNo.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		flowLayout_3.setHgap(10);
		flowLayout_3.setVgap(20);
		pLeft.add(panel_5);
		
		JLabel lblHpNo = new JLabel(" 연락처 ");
		lblHpNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHpNo.setFont(new Font("굴림", Font.BOLD, 15));
		panel_5.add(lblHpNo);
		
		tfHpNo = new JTextField();
		tfHpNo.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(tfHpNo);
		tfHpNo.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		pLeft.add(panel_12);
		
		JPanel pRight = new JPanel();
		panel.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setVgap(20);
		flowLayout_4.setHgap(10);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pRight.add(panel_7);
		
		JLabel lblStdDept = new JLabel("학     과");
		lblStdDept.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdDept.setFont(new Font("굴림", Font.BOLD, 15));
		panel_7.add(lblStdDept);
		
		cbStdDept = new JComboBox<>();
		cbStdDept.setPreferredSize(new Dimension(110,20));
		panel_7.add(cbStdDept);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setVgap(20);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		flowLayout_5.setHgap(10);
		pRight.add(panel_8);
		
		JLabel lblGrade = new JLabel("학     년");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("굴림", Font.BOLD, 15));
		panel_8.add(lblGrade);
		
		cbGrade = new JComboBox<>();
		cbGrade.setPreferredSize(new Dimension(110,20)); //콤보박스 사이즈 조절
		cbGrade.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		panel_8.add(cbGrade);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
		flowLayout_6.setHgap(10);
		flowLayout_6.setVgap(20);
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		pRight.add(panel_9);
		
		JLabel lblDayNightShift = new JLabel("주야구분");
		lblDayNightShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayNightShift.setFont(new Font("굴림", Font.BOLD, 15));
		panel_9.add(lblDayNightShift);
		
		cbDayNightShift = new JComboBox<>();
		cbDayNightShift.setPreferredSize(new Dimension(110,20)); //콤보박스 사이즈 조절
		cbDayNightShift.setModel(new DefaultComboBoxModel(new String[] {"", "주간", "야간"}));
		panel_9.add(cbDayNightShift);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_11.getLayout();
		flowLayout_7.setVgap(20);
		flowLayout_7.setHgap(10);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		pRight.add(panel_11);
		
		JLabel lblStdState = new JLabel("학적상태");
		lblStdState.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdState.setFont(new Font("굴림", Font.BOLD, 15));
		panel_11.add(lblStdState);
		
		cbStdState = new JComboBox<>();
		cbStdState.setPreferredSize(new Dimension(110,20)); //콤보박스 사이즈 조절
		panel_11.add(cbStdState);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_10.getLayout();
		flowLayout_8.setVgap(20);
		flowLayout_8.setHgap(10);
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		pRight.add(panel_10);
		
		JLabel lblMilitaryState = new JLabel("병역상태");
		lblMilitaryState.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilitaryState.setFont(new Font("굴림", Font.BOLD, 15));
		panel_10.add(lblMilitaryState);
		
		cbMilitaryState = new JComboBox<>();
		cbMilitaryState.setPreferredSize(new Dimension(110,20)); //콤보박스 사이즈 조절
		panel_10.add(cbMilitaryState);
	}

	@Override
	public void setItem(StudentData item) {
		System.out.println(item.toString4());
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
