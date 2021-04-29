package student.ui.panel;					//학과별 평균점수인  PolylineBarChart 얘 가져온당

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

public class DeptAvgChart extends JPanel {
	private JPanel panel_1;

	
	//private Container stdpanel;
	public DeptAvgChart() {

		initialize();
	}
	private void initialize() {
		PolylineBarChart demo = new PolylineBarChart(); 

		JFreeChart chart = demo.getChart();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

//		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
		ChartPanel panel_1 = new ChartPanel(chart);
		panel_1.setBorder(new TitledBorder(null, "학과 평균점수", TitledBorder.LEADING, TitledBorder.TOP, null, null));

//		frame1.setSize(800, 400);
//		stdpanel.add(panel);
//		frame1.setVisible(true);
		
	//	panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	

}
