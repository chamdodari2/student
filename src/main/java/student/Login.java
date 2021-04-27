package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import student.service.StudentDataService;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId ;
	private JPasswordField tfPass;
	private JButton btnLogin;
	
	private StudentDataService service;
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		service = new StudentDataService();
		initialize();
	}
	private void initialize() {
		setTitle("학생관리 프로그램 - 로그인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(20, 50, 20, 50));
		panel_1.setBackground(UIManager.getColor("CheckBox.light"));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("굴림", Font.BOLD, 12));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		panel_1.add(tfId);
		
		JLabel lblPass = new JLabel("비밀번호");
		lblPass.setFont(new Font("굴림", Font.BOLD, 12));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPass);
		
		tfPass = new JPasswordField();
		tfPass.setEchoChar('*');
		panel_1.add(tfPass);
		
		JButton btnAddId = new JButton("회원가입");
		btnAddId.setFont(new Font("굴림", Font.BOLD, 12));
		btnAddId.setBackground(Color.WHITE);
		panel_1.add(btnAddId);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("굴림", Font.BOLD, 12));
		btnLogin.setBackground(Color.WHITE);
		panel_1.add(btnLogin);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}
	@SuppressWarnings("deprecation")
	protected void actionPerformedBtnLogin(ActionEvent e) {
		
		if(tfId.getText().equals("210430")) {					//관리자 아이디고
		if(tfPass.getText().equals("rootroot")) {					//관리자 비번이면
			JOptionPane.showMessageDialog(null, "관리자 권한으로 로그인하셨습니다.");		//학생관리 메인띄움
			Main frame = new Main();
			frame.setVisible(true);
			
		}else{
			
			JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다."); 		//관리자 아이디인데 비번 틀리면  틀렸다고 말함
		}
			
			
			
		}else if(tfId.getText().equals("")||tfPass.getText().equals("")) {		//공백 존재하면 공백 존재한다고 하기
			System.out.println("공백존재");
			JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		}else if(tfId.getText().equals("")||tfPass.getText().equals("")) {
			System.out.println("공백존재");
			JOptionPane.showMessageDialog(null, "공백이 존재합니다.");
		}else if(!tfId.getText().equals("")&&!tfPass.getText().equals("")) { //공백이 아니면 비교하기시작하장
				String a =tfId.getText().trim();
				String b = tfPass.getText().trim(); //입력받은거 가져와서 저장,
				//이제 검색해야하는디
				
			System.out.println();
		}else {															//공백 아니고 관리자아디랑 비번도 안맞으면 틀렸다고 할건데, 앞으로는 학생아이디인지 비교해야함 이 위에 학생이랑 비교하는거 추가하면 되고 얘는 걍 두면 된당
			JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
		}
	}
}
