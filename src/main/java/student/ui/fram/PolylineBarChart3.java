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

public class PolylineBarChart3 {
	private static StudentDataService service = new StudentDataService();
	private static StdMgnSearchpanel panel3;
	// Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

	public static void main(final String[] args) {

		PolylineBarChart3 demo = new PolylineBarChart3(); 

		JFreeChart chart = demo.getChart();

		ChartFrame frame3 = new ChartFrame("Bar Chart", chart);
//		ChartPanel panel = new ChartPanel(chart);

		frame3.setSize(800, 400);
		panel3.add(panel3);
		frame3.setVisible(true);

	}

	public JFreeChart getChart() {
		List<StudentData> list2 = new ArrayList<StudentData>();
		list2 = service.showStudentDatas();
		
//		System.out.println("list2>>>>>>" + list2.get(1).getAvg());
//		System.out.println(list2.get(1));
//		System.out.println(list2.get(2));

		double subject1 = 0; //1과목 평균점수 더해서 저장할곳
		double subject2 = 0; //2과목 평균점수 더해서 저장할곳
		double subject3 = 0; //3과목 평균점수 더해서 저장할곳
		
		int subject1Count = 0;
		int subject2Count = 0;
		int subject3Count = 0;
		
		
		for (int i = 0; i < list2.size(); i++) {//모든학생의 수만큼 돌아감
			if (list2.get(i).getSubject1()!= 0) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 성적이 0점이 아니면
				subject1 += list2.get(i).getSubject1();	//인덱스0번학생의 평균점수를 추가한다
				subject1Count += 1;					//한명 추가한다
			}
			if (list2.get(i).getSubject2()!= 0) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 성적이 0점이 아니면
				subject2 += list2.get(i).getSubject2();	//인덱스0번학생의 평균점수를 추가한다
				subject2Count += 1;					//한명 추가한다
			}
			if (list2.get(i).getSubject3()!= 0) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 성적이 0점이 아니면
				subject3 += list2.get(i).getSubject3();	//인덱스0번학생의 평균점수를 추가한다
				subject3Count += 1;					//한명 추가한다
			}
		}
		System.out.println("subject1>>>>"+subject1);
		System.out.println("subject2>>>>"+subject2);
		System.out.println("subject3>>>>"+subject3);
		
		//1과목(국어)
		String  subject1Str = String.format("%.2f", subject1 / subject1Count);
		subject1 = Double.parseDouble(subject1Str);
		//2과목(영어)
		String  subject2Str = String.format("%.2f", subject2 / subject2Count);
		subject2 = Double.parseDouble(subject2Str);
		//3과목(수학)
		String  subject3Str = String.format("%.2f", subject3 / subject3Count);
		subject3 = Double.parseDouble(subject3Str);
		
		
		
		
// 		데이터 생성 /////////////////////////////////차트

	
		
		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset(); // bar chart 3 과목별 평균점수
		
		

		// 데이터 입력 ( 값, 범례, 카테고리 )

		// 그래프 1

		// 그래프 2
		// 그래프 3
		dataset3.addValue(subject1, "과목 평균점수", "국어");
		dataset3.addValue(subject2, "과목 평균점수", "영어");
		dataset3.addValue(subject3, "과목 평균점수", "수학");
	
		
	

		// 렌더링 생성 및 세팅

		// 렌더링 생성

		final BarRenderer renderer3 = new BarRenderer();

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
		renderer3.setSeriesPaint(0, new Color(174,6,162));

        renderer3.setBaseItemLabelFont(f);

        renderer3.setBasePositiveItemLabelPosition(p_center);

        renderer3.setBaseItemLabelGenerator(generator);

        renderer3.setBaseItemLabelsVisible(true);




		// 그래프 3
      
		// plot 생성

		final CategoryPlot plot = new CategoryPlot();

		// plot 에 데이터 적재

		
		plot.setDataset(dataset3);	
		plot.setRenderer(renderer3);
		
		
		
		

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