package student.ui.panel;

import java.awt.Container;

import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import student.ui.fram.PolylineBarChart;
import java.awt.BorderLayout;

public class AvgChart extends JPanel {
	private JPanel panel_1;

	
	//private Container stdpanel;
	public AvgChart() {

		initialize();
	}
	private void initialize() {
		PolylineBarChart demo = new PolylineBarChart(); 

		JFreeChart chart = demo.getChart();

//		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
		ChartPanel panel_1 = new ChartPanel(chart);
		setLayout(new BorderLayout(0, 0));

//		frame1.setSize(800, 400);
//		stdpanel.add(panel);
//		frame1.setVisible(true);
		
	//	panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
	}
	

}
