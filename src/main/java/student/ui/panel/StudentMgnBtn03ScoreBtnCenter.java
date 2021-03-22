package student.ui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

public class StudentMgnBtn03ScoreBtnCenter extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentMgnBtn03ScoreBtnCenter() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		panel.add(panel_1);
		
		JLabel label = new JLabel("학과");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		panel_1.add(label);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(30);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("학년");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(15);
		flowLayout_2.setHgap(30);
		panel.add(panel_3);
		
		JLabel label_2 = new JLabel("학번");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setVgap(15);
		flowLayout_3.setHgap(30);
		panel.add(panel_4);
		
		JLabel label_3 = new JLabel("이름");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_4.add(comboBox_3);
		
		JPanel panel_5 = new JPanel();
		pCenter.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(15);
		panel_5.add(panel_6);
		
		JLabel label_4 = new JLabel("1과목");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		panel_6.add(comboBox_4);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setHgap(30);
		flowLayout_5.setVgap(15);
		panel_5.add(panel_7);
		
		JLabel label_5 = new JLabel("2과목");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("굴림", Font.BOLD, 15));
		panel_7.add(label_5);
		
		JComboBox comboBox_5 = new JComboBox();
		panel_7.add(comboBox_5);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setHgap(30);
		flowLayout_6.setVgap(15);
		panel_5.add(panel_8);
		
		JLabel label_6 = new JLabel("3과목");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("굴림", Font.BOLD, 15));
		panel_8.add(label_6);
		
		JComboBox comboBox_6 = new JComboBox();
		panel_8.add(comboBox_6);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
	}

}
