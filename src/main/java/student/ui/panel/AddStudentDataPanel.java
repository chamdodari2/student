package student.ui.panel;

import student.dto.StudentData;
import student.ui.content.AbstractContentPanel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class AddStudentDataPanel extends AbstractContentPanel<StudentData> {
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;


	public AddStudentDataPanel() {

		initialize();
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
		
		JLabel label = new JLabel("학     번");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(label);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel label_1 = new JLabel("이     름");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(label_1);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel label_2 = new JLabel("주민번호");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(label_2);
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel label_3 = new JLabel(" 연락처 ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_5.add(label_3);
		
		textField_5 = new JTextField();
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		JLabel label_9 = new JLabel("주민번호");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("굴림", Font.BOLD, 15));
		panel_12.add(label_9);
		
		textField_1 = new JTextField();
		panel_12.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JLabel label_4 = new JLabel("학     과");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		panel_7.add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		panel_7.add(comboBox_4);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JLabel label_5 = new JLabel("학     년");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("굴림", Font.BOLD, 15));
		panel_8.add(label_5);
		
		JComboBox comboBox_5 = new JComboBox();
		panel_8.add(comboBox_5);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		JLabel label_6 = new JLabel("성     별");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("굴림", Font.BOLD, 15));
		panel_9.add(label_6);
		
		JComboBox comboBox_6 = new JComboBox();
		panel_9.add(comboBox_6);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		JLabel label_7 = new JLabel("학적상태");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("굴림", Font.BOLD, 15));
		panel_11.add(label_7);
		
		JComboBox comboBox = new JComboBox();
		panel_11.add(comboBox);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		
		JLabel label_8 = new JLabel("병역상태");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("굴림", Font.BOLD, 15));
		panel_10.add(label_8);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_10.add(comboBox_1);
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
		// TODO Auto-generated method stub
		
	}

}
