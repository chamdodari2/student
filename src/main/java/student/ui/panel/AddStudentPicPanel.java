package student.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import student.dto.StudentData;
import student.ui.content.AbstractContentPanel;

@SuppressWarnings("serial")
public class AddStudentPicPanel extends AbstractContentPanel<StudentData> implements ActionListener {
	private JButton btnAddPic;
	private String imgPath = System.getProperty("user.dir")+ File.separator+"images" +File.separator;
	private File chooserFile  =	new File(imgPath);
	private JLabel lblPic;
	private JPanel panel;
	// 

	public File getChooserFile() {
		return chooserFile;
	}
	public AddStudentPicPanel() {
			System.out.println(System.getProperty("user.dir"));
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pWest = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pWest.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(20);
		add(pWest, BorderLayout.CENTER);
		
		panel = new JPanel();
		pWest.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblPic = new JLabel();
	//	lblPic.setIcon(new ImageIcon("C:\\Users\\lenovo\\Desktop\\배수지.jpg"));
	//	lblPic.setIcon(new ImageIcon(imgPath)); //선택 했던걸로 저장
//		chooserFile = new File(chooserFile.getPath());
		
		
		
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setText("사진넣을예정");
		lblPic.setBackground(Color.DARK_GRAY);
		lblPic.setPreferredSize(new Dimension(100, 150));
		panel.add(lblPic, BorderLayout.CENTER);
		
		btnAddPic = new JButton("사진 추가");
		btnAddPic.addActionListener(this);
		btnAddPic.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(btnAddPic, BorderLayout.SOUTH);
		
		

		
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddPic) {
			actionPerformedBtnAddPic(e);
		
		}
	}
	protected void actionPerformedBtnAddPic(ActionEvent e) {
		String openPath = "C:\\workspace_java\\student\\document\\images";  //일로 들어가는게 기본화면
		JFileChooser chooser = new JFileChooser(openPath); //주소를 여기 넣어준당
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG image","jpg","gif","png");
		chooser.setFileFilter(filter);
		int res =chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		} else {

			chooserFile = chooser.getSelectedFile();
			System.out.println("chooserFile 1 >>> "+ chooserFile);
//			System.out.println("chooserFile >>>" + chooserFile);  //김태희가 있는 주소를 가리킨다.
			lblPic.setIcon(new ImageIcon(chooserFile.getPath()));			
			System.out.println("chooserFile>>>2" +chooserFile.getPath());
		
			System.out.println();
//			System.out.println(new ImageIcon(chooserFile.getPath()));
//			lblPic.setIcon(new ImageIcon("C:\\Users\\lenovo\\Desktop\\배수지.jpg"));
		

		}
	}
		
	}

