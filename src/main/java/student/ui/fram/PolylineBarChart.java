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

public class PolylineBarChart {
	private static StudentDataService service = new StudentDataService();
	private static StdMgnSearchpanel panel;
	// Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

	public static void main(final String[] args) {

		PolylineBarChart demo = new PolylineBarChart(); 

		JFreeChart chart = demo.getChart();

		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
//		ChartPanel panel = new ChartPanel(chart);

		frame1.setSize(800, 400);
		panel.add(panel);
		frame1.setVisible(true);

	}

	public JFreeChart getChart() {
		List<StudentData> list2 = new ArrayList<StudentData>();
		list2 = service.showStudentDatas();
		
		System.out.println("list2>>>>>>" + list2.get(1).getAvg());
		System.out.println(list2.get(1));
		System.out.println(list2.get(2));
		double com = 0;  //컴퓨터정보학과 모든 학생의 각 평균점수를 모두 더해서 저장할곳
		double car = 0;
		double san = 0;
		int comCount = 0; //해당학과 인원수 카운트
		int carCount = 0;
		int sanCount = 0;
		
		double grade1 = 0; //학년별 평균점수 더해서 저장할곳
		double grade2 = 0;
		double grade3 = 0;
		double grade4 = 0;
		int grade1Count = 0;
		int grade2Count = 0;
		int grade3Count = 0;
		int grade4Count = 0;
		
		for (int i = 0; i < list2.size(); i++) {//모든학생의 수만큼 돌아감
			if (list2.get(i).getGrade()==1) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 학과명이 컴퓨터정보학과면
				grade1 += list2.get(i).getAvg();	//인덱스0번학생의 평균점수를 추가한다
				grade1Count += 1;					//한명 추가한다
			}
			if (list2.get(i).getGrade()==2) {
				grade2 += list2.get(i).getAvg();
				grade2Count += 1;
			}
			if (list2.get(i).getGrade()==3) {
				grade3 += list2.get(i).getAvg();
				grade3Count += 1;
			}
			if (list2.get(i).getGrade()==4) {
				grade4 += list2.get(i).getAvg();
				grade4Count += 1;
			}
		}
			
			for (int i = 0; i < list2.size(); i++) {//모든학생의 수만큼 돌아감
				if (list2.get(i).getStdDepartment().getDeptName().equals("컴퓨터정보")) { //리스트.인덱스0번  학생정보부터 마지막학생차례까지 돌리는데, 그 학생의 학과명이 컴퓨터정보학과면
					com += list2.get(i).getAvg();	//인덱스0번학생의 평균점수를 추가한다
					comCount += 1;					//한명 추가한다
				}
				if (list2.get(i).getStdDepartment().getDeptName().equals("자동차공학")) {
					car += list2.get(i).getAvg();
					carCount += 1;
				}
				if (list2.get(i).getStdDepartment().getDeptName().equals("산업설비")) {
					san += list2.get(i).getAvg();
					sanCount += 1;
				}
			}
			
		
		//이미 com에는 평균점수 합친거 들어가있고, comCount에는 인원수가 들어가있다
	
		
		
		//컴퓨터정보 차트
//		com = com / comCount;			//해당학과학생의 평균점수 모두 더한거   / 인원수
		String comStr = String.format("%.2f", com / comCount);  //   예) 210.3333/ 3명   ---> 표시는 소수점아래 2자리로 끊어서  넣을꺼임
		// comStr에는 70.33 들어가있다고치면
		com = Double.parseDouble(comStr);   //210.333인 com에다가는 이제 위의 깔끔하게 변환된 comStr을  더블형으로 변환해서 넣는다 그럼 위에 주석한 com=com/comCount와 같다
		
		
		//자동차공학 차트
//		car = car / carCount;		//
		String carStr = String.format("%.2f", car/ carCount);
		car = Double.parseDouble(carStr);
		//산업설비 차트
//		 san = san / sanCount;
		String sanStr = String.format("%.2f", san / sanCount);
		san = Double.parseDouble(sanStr);
		
		//1학년
		String  grade1Str = String.format("%.2f", grade1 / grade1Count);
		grade1 = Double.parseDouble(grade1Str);
		//2학년
		String  grade2Str = String.format("%.2f", grade2 / grade2Count);
		grade1 = Double.parseDouble(grade2Str);
		//3학년
		String  grade3Str = String.format("%.2f", grade3 / grade3Count);
		grade1 = Double.parseDouble(grade3Str);
		//4학년
		String  grade4Str = String.format("%.2f", grade4 / grade4Count);
		grade1 = Double.parseDouble(grade4Str);
		
		
		
		
		
// 		데이터 생성 /////////////////////////////////차트

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1 학과별 평균점수
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // bar chart 2 학년별 평균점수
		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset(); // bar chart 3 과목별 평균점수
		
		

		// 데이터 입력 ( 값, 범례, 카테고리 )

		// 그래프 1

		dataset1.addValue(com, "평균점수", "컴퓨터정보");
		dataset1.addValue(car, "평균점수", "자동차공학");
		dataset1.addValue(san, "평균점수", "산업설비");

		// 그래프 2
		dataset2.addValue(grade1, "평균점수", "1학년");
		dataset2.addValue(grade2, "평균점수", "2학년");
		dataset2.addValue(grade3, "평균점수", "3학년");
		dataset2.addValue(grade4, "평균점수", "4학년");

		// 그래프 3
		dataset3.addValue(com, "평균점수", "컴퓨터정보");

		dataset3.addValue(car, "평균점수", "자동차공학");

		dataset3.addValue(san, "평균점수", "산업설비");

		// 렌더링 생성 및 세팅

		// 렌더링 생성

		final BarRenderer renderer1 = new BarRenderer();			//  			그래프별  모양(?) 생성
		final BarRenderer renderer2 = new BarRenderer();
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

		renderer1.setBaseItemLabelGenerator(generator);

		renderer1.setBaseItemLabelsVisible(true);

		renderer1.setBasePositiveItemLabelPosition(p_center);

		renderer1.setBaseItemLabelFont(f);

//        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

//                GradientPaintTransformType.VERTICAL));

//        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));

		renderer1.setSeriesPaint(0, new Color(0, 162, 255));

		// 그래프 2
		renderer2.setSeriesPaint(0, new Color(232,168,255));

        renderer2.setBaseItemLabelFont(f);

        renderer2.setBasePositiveItemLabelPosition(p_center);

        renderer2.setBaseItemLabelGenerator(generator);

        renderer2.setBaseItemLabelsVisible(true);




		// 그래프 3
        renderer3.setSeriesPaint(0, new Color(232,168,255));

        renderer3.setBaseItemLabelFont(f);

        renderer3.setBasePositiveItemLabelPosition(p_center);

        renderer3.setBaseItemLabelGenerator(generator);

        renderer3.setBaseItemLabelsVisible(true);
		// plot 생성

		final CategoryPlot plot = new CategoryPlot();

		// plot 에 데이터 적재

		plot.setDataset(dataset1);
		plot.setRenderer(renderer1);
		
		plot.setDataset(1,dataset2);	
		plot.setRenderer(1,renderer2);
		
		plot.setDataset(2,dataset3);	
		plot.setRenderer(2,renderer3);
		
		

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