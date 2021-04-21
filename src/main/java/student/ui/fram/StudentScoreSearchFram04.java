package student.ui.fram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.exception.NotSelectedException;
import student.ui.exception.SqlConstraintException;
import student.ui.panel.SouthBtnsPanel;
import student.ui.panel.StdListPanel;
import student.ui.panel.StdMgnScoreSearchpanel;
import student.ui.panel.StdMgnSearchpanel;
import student.ui.panel.StdScoreListPanel;

@SuppressWarnings("serial")
public class StudentScoreSearchFram04 extends JFrame implements ActionListener {

	private StudentDataService service;
	private JPanel contentPane;
	private StdMgnScoreSearchpanel Search_Panel; ///////////////////// private AbstractContentPanel<StudentData> pContent;
											///////////////////// //////////이래야하는거 아잉가
	private StdScoreListPanel pStdList;

	public StudentScoreSearchFram04() {
		service = new StudentDataService();
		initialize();

	}

	private void initialize() {
		setTitle("성적조회/ 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 966, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));

		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		pTop.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("성적조회/관리");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 35));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel.add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("※ 우클릭하시면 성적수정이 가능합니다.");
		lblNewLabel.setForeground(Color.RED);
		panel_1.add(lblNewLabel);

		Search_Panel = new StdMgnScoreSearchpanel();
		Search_Panel.setBorder(new TitledBorder(null, " ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridLayout gl_Search_Panel = (GridLayout) Search_Panel.getLayout();
		
		gl_Search_Panel.setVgap(10);
		gl_Search_Panel.setColumns(4);
		pTop.add(Search_Panel);
		JPopupMenu popMenu =createPopupMenu();
		Search_Panel.createPopupMenu(popMenu);

		JPanel pStdListAndBtns = new JPanel();
		contentPane.add(pStdListAndBtns, BorderLayout.CENTER);
		pStdListAndBtns.setLayout(new BoxLayout(pStdListAndBtns, BoxLayout.Y_AXIS));
		// pLeftList얘를 위에서 한번 생성해주고 여기서는 new StudentMgnBtn01Left();하는게아이고 get으로 해준당

		pStdList = new StdScoreListPanel();
		pStdList.loadData(); // 이거추가해줌
		BorderLayout bl_pStdList = (BorderLayout) pStdList.getLayout();
		bl_pStdList.setHgap(10);
		pStdListAndBtns.add(pStdList);

		Search_Panel.setListTable(pStdList);////////////////
		JPopupMenu popupMenu = createPopupMenu();
		pStdList.setPopupMenu(popupMenu);

		SouthBtnsPanel South_Btns_Panel = new SouthBtnsPanel();
		pStdListAndBtns.add(South_Btns_Panel);
		South_Btns_Panel.setLayout(new BoxLayout(South_Btns_Panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		pStdListAndBtns.add(panel_2);
	}

	private JPopupMenu  createPopupMenu() {// 우클릭시 팝업메뉴 뜨게하기!
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem updateItem = new JMenuItem("성적수정");
		updateItem.addActionListener(popupMenuListner);
		popMenu.add(updateItem);

		/*
		 * JMenuItem deleteItem = new JMenuItem("삭제");
		 * deleteItem.addActionListener(popupMenuListner); popMenu.add(deleteItem);
		 */

		return popMenu;

	}

	ActionListener popupMenuListner = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				/*
				 * if (e.getActionCommand().equals("삭제")) { //삭제 누르면 StudentData delStudent =
				 * pStdList.getItem(); System.out.println(delStudent);
				 * service.removeStudentData(delStudent); pStdList.loadData();
				 * JOptionPane.showMessageDialog(null, delStudent + "삭제되었습니다.");
				 * 
				 * }
				 */
				if (e.getActionCommand().equals("성적수정")) {
					StudentData updaStudentData = pStdList.getItem();
					StudentScoreUpdateFram05 frame = new StudentScoreUpdateFram05();  
					frame.setItem(updaStudentData);///////////////////////업데이트 프레임이었는데 성적업데이트 프레임 따로 만들기!!!
					frame.setVisible(true);
					
				}
			}catch (NotSelectedException | SqlConstraintException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	};

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}