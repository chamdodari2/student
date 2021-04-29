package student.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.Provider.Service;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.content.AbstractContentPanel;
import student.ui.exception.InvalidChechException;

@SuppressWarnings("serial")
public class ViewStudentPicPanel extends AbstractContentPanel<StudentData> implements ActionListener {
	private String imgPath = System.getProperty("user.dir")+ File.separator+"images" +File.separator;
	private File chooserFile  =	new File(imgPath);
	private JLabel lblPic;
	private JPanel panel;
	private String pic ="";
	private StudentData pic2 ;
	
	private String string1 = "";
	
	private StudentDataService service = new StudentDataService();
	
	// 

	public File getChooserFile() {
		return chooserFile;
	}
	public ViewStudentPicPanel() {
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
		lblPic.setIcon(new ImageIcon(imgPath)); //선택 했던걸로 저장
//		chooserFile = new File(chooserFile.getPath());
		
		
		
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setBackground(Color.DARK_GRAY);
		lblPic.setPreferredSize(new Dimension(100, 150));
		panel.add(lblPic, BorderLayout.CENTER);
		
		

		
	}

	
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public JLabel getLblPic() {
		return lblPic;
	}
	public void setLblPic(JLabel lblPic) {
		this.lblPic = lblPic;
	}
	public void setChooserFile(File chooserFile) {
		this.chooserFile = chooserFile;
	}
	
	
	@Override
	public void setItem(StudentData item) {
		lblPic.setIcon(new ImageIcon(item.getPic()));
		
	}

	@Override
	public StudentData getItem() {  ///////////////dto에 pic 생성했음. 널이면 에러 발생시키고, 널 아니면 file이름 가져와서 각 학생의 pic에 넣기
		if(chooserFile==null) {
			throw new InvalidChechException();
		}
		String pic = chooserFile.getName();  //선택한 파일명을 가져와서
		return new StudentData(pic);  //해당 학생의 pic 변수에  넣기
	}
	
	public void setvalue(StudentData pic) {//////////////////StudentData 에 생성해놓은 pic 가져옴
		System.out.println(" imgPath + pic.getPic()>>>>>>" + imgPath + pic.getPic());
		lblPic.setIcon(new ImageIcon(imgPath + pic.getPic()));
		chooserFile = new File(imgPath + pic.getPic());
		pic.setPic(imgPath);
		System.out.println("getpic >>>>"+ pic.getPic());

	}
	
	

	@Override
	public void validCheck() {
		lblPic.setIcon(null);
		chooserFile = null;
		
	}

	@Override
	public void clearTf() {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
	}
	public String getString1() {
		return string1;
	}
		
	}

