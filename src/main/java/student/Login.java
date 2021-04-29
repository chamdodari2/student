package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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

import student.dto.User;
import student.service.StudentDataService;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField tfPass;

	private StudentDataService service = new StudentDataService();

	private JButton btnLogin;

	private User user = new User();

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
		setBounds(700, 400, 490, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

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

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.add(panel_2, BorderLayout.SOUTH);

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("굴림", Font.BOLD, 12));
		btnLogin.setBackground(Color.WHITE);
		panel_2.add(btnLogin);
	}

	public void actionPerformed(ActionEvent e) {

//		String id = String.format("%s", user.getId());
		// System.out.println("user.getId()>>>" + user.getId());
		// System.out.println("id >>> "+ id);
		try {
			int admin = Integer.parseInt(tfId.getText().trim());
			char[] pw = tfPass.getPassword();
			String passwd = "";
			for (char cha : pw) {
				Character.toString(cha);
				passwd += (passwd.equals("")) ? "" + cha + "" : "" + cha + "";
			}
			passwd.trim();
//		System.out.println(admin);
//		System.out.println(passwd);
			User account = service.showUserByAll(admin, passwd);

//		if (account != null) {
			JOptionPane.showMessageDialog(null, "관리자 권한으로 로그인하셨습니다.");
			Main frame = new Main();
			frame.setVisible(true);
			dispose();
		} catch (NumberFormatException e1) {
//		}
//		else {

			JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			tfId.setText("");
			tfPass.setText("");
		}
//		}
	}
}
