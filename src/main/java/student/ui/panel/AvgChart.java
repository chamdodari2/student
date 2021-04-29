package student.ui.panel;

import java.awt.Container;

import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import student.ui.fram.PolylineBarChart;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;

public class AvgChart extends JPanel {
	private JPanel panel_1;

	
	//private Container stdpanel;
	public AvgChart() {

		initialize();
	}
	private void initialize() {
		PolylineBarChart demo = new PolylineBarChart(); 

		JFreeChart chart = demo.getChart();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

//		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
		ChartPanel panel_1 = new ChartPanel(chart);
		panel_1.setBorder(new TitledBorder(null, "\uD559\uACFC\uBCC4 \uD3C9\uADE0\uC810\uC218 \uD1B5\uACC4", TitledBorder.LEADING, TitledBorder.TOP, null, null));

//		frame1.setSize(800, 400);
//		stdpanel.add(panel);
//		frame1.setVisible(true);
		
	//	panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	

}
