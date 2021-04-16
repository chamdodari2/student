package student.ui.panel;//1. 꺽쇠(지네릭) 안에 해당 dto 적어주고 밑에서 해당 콤보박스 검색해서 쌩값 주석처리하고,  패널생성자 안에 initial...밑에 메서드 생성,

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.dto.MilitaryState;
import student.dto.StdDepartment;
import student.dto.StdState;
import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.content.AbstractContentPanel;

@SuppressWarnings("serial")
public class StdMgnSearchpanel extends AbstractContentPanel<StudentData> implements ActionListener, ItemListener {
	private JPanel pStdNo;
	private JLabel lblStdNo;
	private JPanel pStdName;
	private JLabel lblStdName;
	private JComboBox<StdDepartment> cbStdDept; // 1번. 콤보박스에 학과정보 테이블에 들어있는 값들을  List로 가져오려고 선언. 객체화는 아직이다. dto의 기본생성자 호출하면  투스트링으로 지정한 형식으로!입력된다.
	private JLabel lblGrade;
	private JPanel pGrade;
	private JComboBox<StdState> cbGrade;
	private JPanel pStdDept;
	private JLabel lblStdDept;
	// 2. db에서 데이터 가져오기 - 배열로 하는 방법도 있지만 ArrayList로
	ArrayList<String> DayNightShift = new ArrayList<>();
	ArrayList<String> GradeConvertion = new ArrayList<>();
	private JTextField tfStdNo;
	private JTextField tfStdName;
	private JPanel pStdStateName;
	private JLabel lblStdStateName;
	private JComboBox<StdState> cbStdStateName;
	private JPanel pMilitaryStateName;
	private JLabel lblMilitaryStateName;
	private JComboBox<MilitaryState> cbMilitaryStateName;
	private JPanel pDayNightShift;
	private JLabel lblDayNightShift;
	private JComboBox<String> cbDayNightShift;
	private JPanel pSearch;
	private JButton btnSearch;
	private JPanel panel_4;
	private StdListPanel listTable;
	private StudentDataService service; // 학생정도서비스에서 정의해놓은 selectStdDeptListbyall메소드로 가져올거당. 얘에 대한 세터 필요///////////2번
	
	
	


	public void setListTable(StdListPanel listTable) {
		this.listTable = listTable;
	}

	public StdMgnSearchpanel() {
		service = new StudentDataService();
		initialize();

		addDataCbStdDept(); // 1. 학과콤보박스 메서드!
							// //////////////////////////////////////////////////////////////////////3번
		addDataCbStdState();
		addDatacbMilitaryStateName();
		addDatacbDayNightShift();

	}

	private void addDatacbDayNightShift() {

		List<StudentData> dayNightShiftList = service.showStudentDatas();
		DefaultComboBoxModel<StudentData> dayNightShiftModel = new DefaultComboBoxModel<>(
				new Vector<>(dayNightShiftList));
		// System.out.println(stdStateList);
		// cbDayNightShift.setModel(dayNightShiftModel);

	}

	private void addDatacbMilitaryStateName() {
		List<MilitaryState> militaryStateList = service.showMilitaryStates();
		DefaultComboBoxModel<MilitaryState> militaryStateModel = new DefaultComboBoxModel<>(
				new Vector<>(militaryStateList));
		// System.out.println(stdStateList);
		cbMilitaryStateName.setModel(militaryStateModel);

	}

	private void addDataCbStdState() {
		List<StdState> stdStateList = service.showStdStates();
		DefaultComboBoxModel<StdState> stdStateModel = new DefaultComboBoxModel<>(new Vector<>(stdStateList));
		System.out.println(stdStateList);
		cbStdStateName.setModel(stdStateModel);
	}

	private void addDataCbStdDept() { // 2 . 콤보박스안에 값을 넣어준다//////////////////////////////////////////////////////4번
		List<StdDepartment> stdDeptList = service.showStdDepartments(); // 학과 담아서
		System.out.println(stdDeptList);
		DefaultComboBoxModel<StdDepartment> stdDeptModel = new DefaultComboBoxModel<>(new Vector<>(stdDeptList));
		cbStdDept.setModel(stdDeptModel);
	}

	private void initialize() {
		setLayout(new GridLayout(0, 8, 10, 0));

		pStdNo = new JPanel();
		pStdNo.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStdNo);
		pStdNo.setLayout(new GridLayout(0, 2, 0, 0));

		lblStdNo = new JLabel("학     번");
		lblStdNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdNo.setFont(new Font("굴림", Font.BOLD, 12));
		pStdNo.add(lblStdNo);

		tfStdNo = new JTextField();
		pStdNo.add(tfStdNo);
		tfStdNo.setColumns(10);

		pStdName = new JPanel();
		pStdName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStdName);
		pStdName.setLayout(new GridLayout(0, 2, 0, 0));

		lblStdName = new JLabel("이     름");
		lblStdName.setFont(new Font("굴림", Font.BOLD, 12));
		lblStdName.setHorizontalAlignment(SwingConstants.CENTER);
		pStdName.add(lblStdName);

		tfStdName = new JTextField();
		pStdName.add(tfStdName);
		tfStdName.setColumns(10);

		pStdDept = new JPanel();
		pStdDept.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStdDept);
		pStdDept.setLayout(new GridLayout(0, 2, 0, 0));

		lblStdDept = new JLabel("학     과");
		lblStdDept.setFont(new Font("굴림", Font.BOLD, 12));
		lblStdDept.setHorizontalAlignment(SwingConstants.CENTER);
		pStdDept.add(lblStdDept);

		// StdDepartment stdDepartment = new StdDepartment();
		cbStdDept = new JComboBox<>();
		cbStdDept.addActionListener(this);
		// cbStdDept.setModel(new DefaultComboBoxModel(new String[] {"컴퓨터정보", "자동차공학",
		// "산업설비"}));
		// cbStdDept.addItemListener((ItemListener) this);
		// pStdDept.addItemListener(this);

		pStdDept.add(cbStdDept);
		pGrade = new JPanel();
		pGrade.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pGrade);
		pGrade.setLayout(new GridLayout(0, 2, 0, 0));

		lblGrade = new JLabel("학     년");
		lblGrade.setFont(new Font("굴림", Font.BOLD, 12));
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(lblGrade);

		cbGrade = new JComboBox<>();
		cbGrade.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));
		pGrade.add(cbGrade);

		pStdStateName = new JPanel();
		pStdStateName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStdStateName);
		pStdStateName.setLayout(new GridLayout(0, 2, 0, 0));

		lblStdStateName = new JLabel("학적상태");
		lblStdStateName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdStateName.setFont(new Font("굴림", Font.BOLD, 12));
		pStdStateName.add(lblStdStateName);

		cbStdStateName = new JComboBox<>();
		// cbStdStateName.setModel(new DefaultComboBoxModel(new String[] {"재학", "휴학"}));

		pStdStateName.add(cbStdStateName);

		pMilitaryStateName = new JPanel();
		pMilitaryStateName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pMilitaryStateName);
		pMilitaryStateName.setLayout(new GridLayout(0, 2, 0, 0));

		lblMilitaryStateName = new JLabel("병역상태");
		lblMilitaryStateName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilitaryStateName.setFont(new Font("굴림", Font.BOLD, 12));
		pMilitaryStateName.add(lblMilitaryStateName);

		cbMilitaryStateName = new JComboBox<>();
		// cbMilitaryStateName.setModel(new DefaultComboBoxModel(new String[] {"군필",
		// "미필"}));
		pMilitaryStateName.add(cbMilitaryStateName);

		pDayNightShift = new JPanel();
		pDayNightShift.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pDayNightShift);
		pDayNightShift.setLayout(new GridLayout(0, 2, 0, 0));

		lblDayNightShift = new JLabel("주야구분");
		lblDayNightShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayNightShift.setFont(new Font("굴림", Font.BOLD, 12));
		pDayNightShift.add(lblDayNightShift);

		cbDayNightShift = new JComboBox<>();
		cbDayNightShift.setModel(new DefaultComboBoxModel(new String[] { "", "주간", "야간" }));
		pDayNightShift.add(cbDayNightShift);

		pSearch = new JPanel();
		pSearch.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pSearch);
		pSearch.setLayout(new GridLayout(0, 2, 0, 0));

		panel_4 = new JPanel();
		pSearch.add(panel_4);

		btnSearch = new JButton("검     색");
		btnSearch.addActionListener(this);

		pSearch.add(btnSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbStdDept) {
			actionPerformedCbStdDept(e); // 학과콤보박스 누르면
		}

		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	public StudentData getStudentData() { //getItem임

		String string = tfStdNo.getText() + tfStdName.getText();

		int idx = cbDayNightShift.getSelectedIndex() + cbGrade.getSelectedIndex()
				+ cbMilitaryStateName.getSelectedIndex() + cbStdDept.getSelectedIndex()
				+ cbStdStateName.getSelectedIndex();
		// tfName.getText() + tfStdNo.getText()).equals("")
		if (idx == 0 && string.equals("")) {
			return null;
		}
		int stdNo = Integer.parseInt(tfStdNo.getText().equals("") ? "0" : tfStdNo.getText());
		String stdName = tfStdName.getText();
		StdDepartment stdDepartment = (StdDepartment) cbStdDept.getSelectedItem();

		int grade = 0;
		if ((String) cbGrade.getSelectedItem() != "")
			grade = Integer.parseInt((String) cbGrade.getSelectedItem());//
		StdState stdState = (StdState) cbStdStateName.getSelectedItem();
		MilitaryState militaryState = (MilitaryState) cbMilitaryStateName.getSelectedItem();
		String dayNightShift = (String) cbDayNightShift.getSelectedItem();

		return new StudentData(stdNo, stdName, stdDepartment, grade, stdState, militaryState, dayNightShift);

	}

	protected void actionPerformedBtnSearch(ActionEvent e) {  //조건끝!!
	
		System.out.println(getStudentData());
		StudentData stdData = getStudentData();
		String where = "";
		if (stdData != null) {
			where =" where ";
			if(stdData.getStdNo() != 0) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("stdNo = " + stdData.getStdNo());
			} 
			if(!stdData.getStdName().equals("")) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("stdName = " + stdData.getStdName());
			}
			if(stdData.getStdDepartment().getDeptCode()!=null) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("deptCode = " + stdData.getStdDepartment().getDeptCode());
			}
			if(stdData.getGrade()!= 0) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("grade = " + stdData.getGrade());
			}if(stdData.getStdState().getStateCode()!=null) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("stateCode = " + "'" +stdData.getStdState().getStateCode()+"'");//
			}if(stdData.getMilitaryState().getMilitaryCode()!=null) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("militaryCode = " +"'"+ stdData.getMilitaryState().getMilitaryCode()+"'");
			}if(!stdData.getDayNightShift().equals("")) {
				if (!where.equals(" where ")) {	where += " and ";}
				where += ("dayNightShift = " +"'" + stdData.getDayNightShift()+"'");
			}
		}
	
		listTable.loadData2(where);
	
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbStdDept) {
			itemStateChangedCbStdDept(e);
		}

	}

	private void itemStateChangedCbStdDept(ItemEvent e) {

	}

	protected void actionPerformedCbStdDept(ActionEvent e) {

	}

	@Override
	public void setItem(StudentData item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StudentData getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validCheck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearTf() {
		tfStdNo.setText("");
		tfStdName.setText("");
	}

	public void createPopupMenu(JPopupMenu popMenu) {
		// TODO Auto-generated method stub
		
	}
}
