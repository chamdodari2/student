package student.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import student.ui.content.AbstractContentPanel;
import student.ui.exception.InvalidChechException;
import student.ui.exception.SqlConstraintException;
import student.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public abstract class AbstractManagerUI<T> extends JFrame implements ActionListener {

   private JPanel contentPane;
   protected JButton btnAdd;
   private JButton btnCancel;
   
   protected AbstractContentPanel<T> pContent; // AbstractContentPanel
   protected AbstractCustomTablePanel<T> pList; // AbstractCustomTablePanel
   protected JMenuItem empListByTitleItem;
   
   protected static final String TITLE_MENU = "동일 직책 사원 보기";   //우클릭 했을떄 똑같이 동일직책 사원보기 나오는거 싫어서!! 바꿈
   protected static final String DEPT_MENU = "동일 부서 사원 보기"; 
   protected static final String EMP_MENU = "사원 세부정보 보기"; 
   
   
   public AbstractManagerUI() {
      setService();      // service 연결
      initialize();   
      tableLoadData();   // component load data
   }

   private void initialize() {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(200, 200, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

      pContent = createContentPanel();
      contentPane.add(pContent);

      JPanel pBtn = new JPanel();
      contentPane.add(pBtn);

      btnAdd = new JButton("추가");
      btnAdd.addActionListener(this);
      pBtn.add(btnAdd);

      btnCancel = new JButton("취소");
      btnCancel.addActionListener(this);
      pBtn.add(btnCancel);

      pList = createTablePanel();
      contentPane.add(pList);
      
      JPopupMenu popupMenu = createPopupMenu();
      pList.setPopupMenu(popupMenu);
   }

   
   private JPopupMenu createPopupMenu() {
      JPopupMenu popMenu = new JPopupMenu();
      
      JMenuItem updateItem = new JMenuItem("수정");
      updateItem.addActionListener(this);
      popMenu.add(updateItem);
      
      JMenuItem deleteItem = new JMenuItem("삭제");
      deleteItem.addActionListener(this);
      popMenu.add(deleteItem);
      
      empListByTitleItem = new JMenuItem("동일 직책 사원 보기");    //필드로 뺏음!!!! 요 텍스트가 세개가있음
      empListByTitleItem.addActionListener(this);
      popMenu.add(empListByTitleItem);
      
      return popMenu;
   }
   
   public void actionPerformed(ActionEvent e) {
      try {
         if (e.getSource() instanceof JMenuItem) {
            if (e.getActionCommand().equals("삭제")) {
               actionPerformedMenuDelete();
            }
            if (e.getActionCommand().equals("수정")) {
               actionPerformedMenuUpdate();
            }
            if (e.getActionCommand().equals(AbstractManagerUI.TITLE_MENU)) { //따로 if문 세개 적어줘도 되고, 해도되고, 여기 한줄에 ||로 한줄에 다적어도된다.
               actionPerformedMenuGubun();
            }
            if (e.getActionCommand().equals(AbstractManagerUI.DEPT_MENU)) {
                actionPerformedMenuGubun();
             }
            if (e.getActionCommand().equals(AbstractManagerUI.EMP_MENU)) {
                actionPerformedMenuGubun();
             }
         } else {
            if (e.getSource() == btnCancel) {
               actionPerformedBtnCancel(e);
            }
            if (e.getSource() == btnAdd) {
               if (btnAdd.getText().equals("추가")) {
                  actionPerformedBtnAdd(e);
               }
               if (btnAdd.getText().equals("수정")) {
                  actionperformedBtnUpdate(e);
               }
            }
         }
      } catch (InvalidChechException | SqlConstraintException e1) {
         JOptionPane.showMessageDialog(null, e1.getMessage());
//         pContent.clearTf();
      } catch (Exception e1) {
         e1.printStackTrace();
      }
   }

   protected abstract void setService();
   
   protected abstract void tableLoadData();
   
   protected abstract AbstractContentPanel<T> createContentPanel();   ///
   
   protected abstract AbstractCustomTablePanel<T> createTablePanel();///

   protected abstract void actionPerformedMenuGubun();

   protected abstract void actionPerformedMenuUpdate();

   protected abstract void actionPerformedMenuDelete();
   
   protected abstract void actionperformedBtnUpdate(ActionEvent e);
   
   protected abstract void actionPerformedBtnAdd(ActionEvent e);
   
   protected void actionPerformedBtnCancel(ActionEvent e) {
      pContent.clearTf();
      
      if (btnAdd.getText().contentEquals("수정")) {
         btnAdd.setText("추가");
      }
   }
}