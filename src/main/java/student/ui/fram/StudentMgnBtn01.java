package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.ui.panel.StudentMgnBtn01Left;
import student.ui.panel.StudentMgnBtn01Right1;
import student.ui.panel.StudentMgnBtn01Right2;
import student.ui.panel.StudentMgnBtn01Top;

public class StudentMgnBtn01 extends JFrame {

	private JPanel contentPane;

	public StudentMgnBtn01() {
		initialize();
	}
	private void initialize() {
		setTitle("학적/학생관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 1239, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(15, 10));
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("학적/학생관리");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 35));
		pTop.add(lblTitle);
		
		StudentMgnBtn01Top pSelect = new StudentMgnBtn01Top();
		pTop.add(pSelect, BorderLayout.SOUTH);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 15, 0));
		
		StudentMgnBtn01Left pLeftList = new StudentMgnBtn01Left();
		BorderLayout borderLayout = (BorderLayout) pLeftList.getLayout();
		borderLayout.setHgap(10);
		pCenter.add(pLeftList);
		
		JPanel pRightList = new JPanel();
		pCenter.add(pRightList);
		pRightList.setLayout(new BorderLayout(10, 0));
		
		StudentMgnBtn01Right2 pRightSouth = new StudentMgnBtn01Right2();
		pRightList.add(pRightSouth, BorderLayout.SOUTH);
		
		StudentMgnBtn01Right1 pRightCenter = new StudentMgnBtn01Right1();
		pRightList.add(pRightCenter, BorderLayout.CENTER);
	}

}
