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
import javax.swing.JTextField;
import java.awt.Insets;

public class StdMgnSearchpanel extends JPanel {
	private JPanel pStdNo;
	private JLabel lblStdNo;
	private JPanel pStdName;
	private JLabel lblStdName;
	private JComboBox<GradeConvertion> cbStdDept;
	private JLabel cbGrade;
	private JPanel pGrade;
	private JComboBox<String> cbStateName_1;
	private JPanel pStdDept;
	private JLabel lblStdDept;   
	//2. db에서 데이터 가져오기  - 배열로 하는 방법도 있지만 ArrayList로 
	ArrayList<String> DayNightShift =  new ArrayList<>();
	ArrayList<String> GradeConvertion =  new ArrayList<>();
	private JTextField tfStdNo;
	private JTextField tfStdName;
	private JPanel pStdStateName;
	private JLabel lblStdStateName;
	private JComboBox<String> cbStdStateName;
	private JPanel pMilitaryStateName;
	private JLabel lblMilitaryStateName;
	private JComboBox<String> cbMilitaryStateName;
	private JPanel pDayNightShift;
	private JLabel lblDayNightShift;
	private JComboBox<String> cbDayNightShift;
	private JPanel pSearch;
	private JButton btnSearch;
	private JPanel panel_4;
	

	public StdMgnSearchpanel() {

		initialize();
		
		
		
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
		
		cbStdDept = new JComboBox<>();
		cbStdDept.setModel(new DefaultComboBoxModel(new String[] {"전산학과"}));
		pStdDept.add(cbStdDept);
		
		pGrade = new JPanel();
		pGrade.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pGrade);
		pGrade.setLayout(new GridLayout(0, 2, 0, 0));
		
		cbGrade = new JLabel("학     년");
		cbGrade.setFont(new Font("굴림", Font.BOLD, 12));
		cbGrade.setHorizontalAlignment(SwingConstants.CENTER);
		pGrade.add(cbGrade);
		
		cbStateName_1 = new JComboBox<>();
		cbStateName_1.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		pGrade.add(cbStateName_1);
		
		pStdStateName = new JPanel();
		pStdStateName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pStdStateName);
		pStdStateName.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblStdStateName = new JLabel("학적상태");
		lblStdStateName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdStateName.setFont(new Font("굴림", Font.BOLD, 12));
		pStdStateName.add(lblStdStateName);
		
		cbStdStateName = new JComboBox<String>();
		cbStdStateName.setModel(new DefaultComboBoxModel(new String[] {"재학"}));
		pStdStateName.add(cbStdStateName);
		
		pMilitaryStateName = new JPanel();
		pMilitaryStateName.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pMilitaryStateName);
		pMilitaryStateName.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblMilitaryStateName = new JLabel("병역상태");
		lblMilitaryStateName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMilitaryStateName.setFont(new Font("굴림", Font.BOLD, 12));
		pMilitaryStateName.add(lblMilitaryStateName);
		
		cbMilitaryStateName = new JComboBox<String>();
		cbMilitaryStateName.setModel(new DefaultComboBoxModel(new String[] {"군필"}));
		pMilitaryStateName.add(cbMilitaryStateName);
		
		pDayNightShift = new JPanel();
		pDayNightShift.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pDayNightShift);
		pDayNightShift.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblDayNightShift = new JLabel("주야구분");
		lblDayNightShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayNightShift.setFont(new Font("굴림", Font.BOLD, 12));
		pDayNightShift.add(lblDayNightShift);
		
		cbDayNightShift = new JComboBox<String>();
		cbDayNightShift.setModel(new DefaultComboBoxModel(new String[] {"주간"}));
		pDayNightShift.add(cbDayNightShift);
		
		pSearch = new JPanel();
		pSearch.setBorder(new EmptyBorder(0, 20, 0, 20));
		add(pSearch);
		pSearch.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_4 = new JPanel();
		pSearch.add(panel_4);
		
		btnSearch = new JButton("검     색");
		pSearch.add(btnSearch);
	}

}
