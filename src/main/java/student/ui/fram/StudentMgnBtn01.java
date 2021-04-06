package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import student.ui.panel.StdListTablePanel;
import student.ui.panel.StudentMgnBtn01Right1;
import student.ui.panel.SouthBtnsPanel;
import student.ui.panel.StdMgnSearchpanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DropMode;

public class StudentMgnBtn01 extends JFrame {

	private JPanel contentPane;

	public StudentMgnBtn01() {
		initialize();
	}
	private void initialize() {
		setTitle("학생조회/ 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 966, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		pTop.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("학생조회/관리");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 35));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("ㅇㅇㅇㅇㅇㅇ");
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("※ 학생목록에서 해당학생을 선택하여 우클릭하시면 상세정보조회/학생삭제 가능합니다.");
		lblNewLabel.setForeground(Color.RED);
		panel_1.add(lblNewLabel);
		
		StdMgnSearchpanel Search_Panel = new StdMgnSearchpanel();
		Search_Panel.setBorder(new TitledBorder(null, " ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridLayout gl_Search_Panel = (GridLayout) Search_Panel.getLayout();
		gl_Search_Panel.setVgap(10);
		gl_Search_Panel.setColumns(4);
		pTop.add(Search_Panel);
		
		JPanel pStdListAndBtns = new JPanel();
		contentPane.add(pStdListAndBtns, BorderLayout.CENTER);
		pStdListAndBtns.setLayout(new BoxLayout(pStdListAndBtns, BoxLayout.Y_AXIS));
		//pLeftList얘를 위에서 한번 생성해주고 여기서는   new StudentMgnBtn01Left();하는게아이고 get으로 해준당
		StdListTablePanel pStdList = new StdListTablePanel();
		BorderLayout bl_pStdList = (BorderLayout) pStdList.getLayout();
		bl_pStdList.setHgap(10);
		pStdListAndBtns.add(pStdList);
		
		SouthBtnsPanel South_Btns_Panel = new SouthBtnsPanel();
		pStdListAndBtns.add(South_Btns_Panel);
		South_Btns_Panel.setLayout(new BoxLayout(South_Btns_Panel, BoxLayout.X_AXIS));
	}

}
