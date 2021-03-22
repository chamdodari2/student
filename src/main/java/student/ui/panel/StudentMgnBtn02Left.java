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

public class StudentMgnBtn02Left extends JPanel {

	/**
	 * Create the panel.
	 */
	public StudentMgnBtn02Left() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(30);
		panel.add(panel_1);
		
		JLabel label = new JLabel("성      별");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		panel_1.add(label);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(20);
		flowLayout_1.setHgap(30);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("학      년");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_2.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(20);
		flowLayout_2.setHgap(30);
		panel.add(panel_3);
		
		JLabel label_2 = new JLabel("학적사항");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_3.add(comboBox_2);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setVgap(20);
		flowLayout_3.setHgap(30);
		panel.add(panel_4);
		
		JLabel label_3 = new JLabel("병역사항");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_4.add(comboBox_3);
	}

}
