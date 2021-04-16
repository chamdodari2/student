package student.ui.panel;

import student.dto.StudentData;
import student.ui.content.AbstractContentPanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AddStudentPicPanel extends AbstractContentPanel<StudentData> {

	
	public AddStudentPicPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		add(pWest, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		pWest.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPic = new JLabel();
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setText("사진넣을예정");
		lblPic.setBackground(Color.DARK_GRAY);
		lblPic.setPreferredSize(new Dimension(100, 150));
		panel.add(lblPic, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("사진 추가");
		panel.add(btnNewButton, BorderLayout.SOUTH);
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
