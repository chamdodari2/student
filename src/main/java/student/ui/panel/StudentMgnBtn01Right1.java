package student.ui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class StudentMgnBtn01Right1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public StudentMgnBtn01Right1() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("▼상세 정보");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pCenter.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setVgap(15);
		panel_1.add(panel_7);
		
		JLabel label_8 = new JLabel("주야구분");
		label_8.setFont(new Font("굴림", Font.BOLD, 15));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(label_8);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.BOLD, 15));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		panel_7.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel label_7 = new JLabel("학     과");
		label_7.setFont(new Font("굴림", Font.BOLD, 15));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_7);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.BOLD, 15));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		panel_6.add(textField);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setVgap(15);
		panel_1.add(panel_8);
		
		JLabel label_9 = new JLabel("학     년");
		label_9.setFont(new Font("굴림", Font.BOLD, 15));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("굴림", Font.BOLD, 15));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		panel_8.add(textField_5);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel label_10 = new JLabel("성     명");
		label_10.setFont(new Font("굴림", Font.BOLD, 15));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("굴림", Font.BOLD, 15));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		panel_9.add(textField_7);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setVgap(15);
		panel_1.add(panel_10);
		
		JLabel label_11 = new JLabel("학     번");
		label_11.setFont(new Font("굴림", Font.BOLD, 15));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("굴림", Font.BOLD, 15));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		panel_10.add(textField_8);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_2.getLayout();
		flowLayout_5.setVgap(15);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("생년월일");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel label_1 = new JLabel("학     적");
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_11.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.BOLD, 15));
		panel_11.add(comboBox);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_12.getLayout();
		flowLayout_4.setVgap(15);
		panel_1.add(panel_12);
		
		JLabel label_2 = new JLabel("병     역");
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_12.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_12.add(comboBox_1);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_13.getLayout();
		flowLayout_6.setVgap(15);
		panel_1.add(panel_13);
		
		JLabel label_3 = new JLabel("성     별");
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_13.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_13.add(comboBox_2);
		
		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
	}

}
