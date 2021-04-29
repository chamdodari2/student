package student.ui.fram;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.panel.StdMgnSearchpanel;

public class PolylineBarChart2 {
	private static StudentDataService service = new StudentDataService();
	private static StdMgnSearchpanel panel2;
	// Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

	public static void main(final String[] args) {

		PolylineBarChart2 demo = new PolylineBarChart2(); 

		JFreeChart chart = demo.getChart();

		ChartFrame frame2 = new ChartFrame("Bar Chart", chart);
//		ChartPanel panel = new ChartPanel(chart);

	//	frame2.setSize(800, 400);
		panel2.add(panel2);
	//	frame2.setVisible(true);

	}

	public JFreeChart getChart() {
		List<StudentData> list2 = new ArrayList<StudentData>();
		list2 = service.showStudentDatas();
		
//		System.out.println("list2>>>>>>" + list2.get(1).getAvg());
//		System.out.println(list2.get(1));
//		System.out.println(list2.get(2));

		double grade1 = 0; //학년별 평균점수 더해서 저장할곳
		double grade2 = 0;
		double grade3 = 0;
		double grade4 = 0;
		int grade1Count = 0;
		int grade2Count = 0;
		int grade3Count = 0;
		int grade4Count = 0;
		
		for (int i = 0; i < list2.size(); i++) {//모든학생의 수만큼 돌아감
			if (list2.get(i).getGrade()== 1) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 학과명이 컴퓨터정보학과면
				grade1 += list2.get(i).getAvg();	//인덱스0번학생의 평균점수를 추가한다
				grade1Count += 1;					//한명 추가한다
			}
			if (list2.get(i).getGrade()== 2) {
				grade2 += list2.get(i).getAvg();
				grade2Count += 1;
			}
			if (list2.get(i).getGrade()== 3) {
				grade3 += list2.get(i).getAvg();
				grade3Count += 1;
			}
			if (list2.get(i).getGrade()== 4) {
				grade4 += list2.get(i).getAvg();
				grade4Count += 1;
			}
		}
		System.out.println("grade4 >>>>> "+grade4);
		System.out.println("gradeCount >>>>> "+ grade4Count);
		
		//1학년
		String  grade1Str = String.format("%.2f", grade1 / grade1Count);
		grade1 = Double.parseDouble(grade1Str);
		//2학년
		String  grade2Str = String.format("%.2f", grade2 / grade2Count);
		grade2 = Double.parseDouble(grade2Str);
		//3학년
		String  grade3Str = String.format("%.2f", grade3 / grade3Count);
		grade3 = Double.parseDouble(grade3Str);
		//4학년
		String  grade4Str = String.format("%.2f", grade4 / grade4Count);
		grade4 = Double.parseDouble(grade4Str);
		
		
		
		
		
// 		데이터 생성 /////////////////////////////////차트

	
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // bar chart 2 학년별 평균점수
		//DefaultCategoryDataset dataset3 = new DefaultCategoryDataset(); // bar chart 3 과목별 평균점수
		
		

		// 데이터 입력 ( 값, 범례, 카테고리 )

		// 그래프 1

		
		// 그래프 2
		dataset2.addValue(grade1, "학년 평균점수", "1학년");
		dataset2.addValue(grade2, "학년 평균점수", "2학년");
		dataset2.addValue(grade3, "학년 평균점수", "3학년");
		dataset2.addValue(grade4, "학년 평균점수", "4학년");

		// 그래프 3
	

		// 렌더링 생성 및 세팅

		// 렌더링 생성

		final BarRenderer renderer2 = new BarRenderer();

		// 공통 옵션 정의

		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

		final ItemLabelPosition p_center = new ItemLabelPosition(

				ItemLabelAnchor.CENTER, TextAnchor.CENTER

		);

		final ItemLabelPosition p_below = new ItemLabelPosition(

				ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT

		);

		Font f = new Font("Gulim", Font.BOLD, 14);

		Font axisF = new Font("Gulim", Font.PLAIN, 14);

		// 렌더링 세팅  												//그래프 모양 위에서 정한거 세팅 

		// 그래프 1

		
//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));


		// 그래프 2
		renderer2.setSeriesPaint(0, new Color(16,131,32));

        renderer2.setBaseItemLabelFont(f);

        renderer2.setBasePositiveItemLabelPosition(p_center);

        renderer2.setBaseItemLabelGenerator(generator);

        renderer2.setBaseItemLabelsVisible(true);




		// 그래프 3
      
		// plot 생성

		final CategoryPlot plot = new CategoryPlot();

		// plot 에 데이터 적재

		
		plot.setDataset(dataset2);	
		plot.setRenderer(renderer2);
		
		
		
		

		// plot 기본 설정

		plot.setOrientation(PlotOrientation.VERTICAL); // 그래프 표시 방향

		plot.setRangeGridlinesVisible(true); // X축 가이드 라인 표시여부

		plot.setDomainGridlinesVisible(true); // Y축 가이드 라인 표시여부

		// 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X축 세팅

		plot.setDomainAxis(new CategoryAxis()); // X축 종류 설정

		plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정

		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // 카테고리 라벨 위치 조정

		// Y축 세팅

		plot.setRangeAxis(new NumberAxis()); // Y축 종류 설정

		plot.getRangeAxis().setTickLabelFont(axisF); // Y축 눈금라벨 폰트 조정

		// 세팅된 plot을 바탕으로 chart 생성

		final JFreeChart chart = new JFreeChart(plot);

//        chart.setTitle("Overlaid Bar Chart"); // 차트 타이틀

//        TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new Font("SansSerif", Font.PLAIN, 9));

//        copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

//        chart.addSubtitle(copyright);  // 차트 서브 타이틀

		return chart;

	}

}