package student.ui.panel;					//학과별 평균점수인  PolylineBarChart 얘 가져온당

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import student.ui.fram.PolylineBarChart2;

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
		ChartPanel panel_1 = new ChartPanel(chart);
		panel_1.setBorder(new TitledBorder(null, "학년 평균점수", TitledBorder.LEADING, TitledBorder.TOP, null, null));

//		frame1.setSize(800, 400);
//		stdpanel.add(panel);
//		frame1.setVisible(true);
		
	//	panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	

}
