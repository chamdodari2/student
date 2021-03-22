package student.ui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentMgnBtn03Center extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public StudentMgnBtn03Center() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uD559\uACFC", "\uC774\uB984", "\uD559\uBC88", "1\uACFC\uBAA9", "2\uACFC\uBAA9", "3\uACFC\uBAA9", "\uCD1D\uC810", "\uD3C9\uADE0", "\uD3C9\uC5B4", "\uD3C9\uC810"
			}
		));
		scrollPane.setViewportView(table);
	}

}
