package student.ui.panel;					//학과별 평균점수인  PolylineBarChart 얘 가져온당

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import student.ui.fram.PolylineBarChart2;
import javax.swing.UIManager;
import java.awt.Color;

public class GradeAvgChart extends JPanel {
	private JPanel panel_1;

	
	//private Container stdpanel;
	public GradeAvgChart() {

		initialize();
	}
	private void initialize() {
		PolylineBarChart2 demo = new PolylineBarChart2(); 

		JFreeChart chart = demo.getChart();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

//		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
		ChartPanel panel = new ChartPanel(chart);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

//		frame1.setSize(800, 400);
//		stdpanel.add(panel);
//		frame1.setVisible(true);
		
	//	panel_1 = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	}
	

}
