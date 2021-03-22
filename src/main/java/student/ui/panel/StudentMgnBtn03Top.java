package student.ui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;

public class StudentMgnBtn03Top extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentMgnBtn03Top() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(40);
		add(panel);
		
		JButton btnNewButton = new JButton("성적 수정");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(20);
		add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("학과");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(20);
		add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("학년");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(20);
		add(panel_4);
		
		JLabel label = new JLabel("조회");
		label.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(label);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
	}

}
