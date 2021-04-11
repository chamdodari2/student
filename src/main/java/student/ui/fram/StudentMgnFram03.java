package student.ui.fram;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import student.ui.panel.AddStudentPicPanel;
import java.awt.GridLayout;
import student.ui.panel.AddStudentDataPanel;
import javax.swing.BoxLayout;

public class StudentMgnFram03 extends JFrame {

	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public StudentMgnFram03() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("세부정보");
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		AddStudentPicPanel panel_1 = new AddStudentPicPanel();
		contentPane.add(panel_1);
		
		AddStudentDataPanel panel = new AddStudentDataPanel();
		contentPane.add(panel);
	}

}
