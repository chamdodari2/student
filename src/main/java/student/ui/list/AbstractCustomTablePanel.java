package student.ui.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public abstract class AbstractCustomTablePanel<T> extends JPanel {
	protected JTable table;
	protected List<T> list;

	public AbstractCustomTablePanel() {
		initialize();
	}

	public abstract T getItem(); /*
									 * { //선택이 안되면 마이너스1을 리턴한다 int idx = table.getSelectedRow(); if(idx == -1 ) {
									 * throw new NotSelectedException(); } return list.get(idx); }
									 */

	public void loadData() {
		initList();
		setList();
	}

	public void setPopupMenu(JPopupMenu popMenu) {
		table.setComponentPopupMenu(popMenu);
	}

	public abstract void initList();

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}

	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(/* getData(), getColumnNames() */);
		return model;
	}

	public Object[][] getData() {
		return new Object[][] { { null, null, null }, };
	}

	public void setList() {
		//	protected List<T> list; 얘는 필드에 선언되어 있음
		Object[][] data = null;
		if (list != null) {  //학적상테 테이블이 비어있지 않다면
			 data = new Object[list.size()][]; //data라는 이차배열에 순서대로 담을예정. data[테이블에 담긴 데이터의 길이][];
			for (int i = 0; i < data.length; i++) { //data[i] =list.get(i) data에 순서대로 담기위해서 인덱스 0에 테이블의 0번째인덱스에 에 있는 거 집어넣기, 테이블에 담긴게 동날때까지 반복 
				data[i] = toArray(list.get(i));
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "해당 조건에 맞는 검색결과가 없습니다.");  //만약에 테이블에 있는게 없으면 띄워줄 메세지
		}

		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		setAlignAndWidth();
	}

	/**
	 * //컬럼내용 정렬 setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
	 * 
	 * //컬럼별 너비 조정 setTableCellWidth(100, 250, 100);
	 */
	protected abstract void setAlignAndWidth();

	protected void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public abstract Object[] toArray(T t);

	public abstract String[] getColumnNames();

	private class CustomTableModel extends DefaultTableModel {

		public CustomTableModel() {
			// TODO Auto-generated constructor stub
		}

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}