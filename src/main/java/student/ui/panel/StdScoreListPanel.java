package student.ui.panel;

import javax.swing.SwingConstants;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.exception.NotSelectedException;
import student.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public class StdScoreListPanel extends AbstractCustomTablePanel<StudentData> {
	StudentDataService service;

	public StdScoreListPanel() {
	service = new StudentDataService();
	}

	@Override
	public StudentData getItem() {
		int row = table.getSelectedRow();
		if(row == -1) {
			throw new NotSelectedException();
		}
		int stdNo =(int)table.getValueAt(row, 0);
		return list.get(list.indexOf(new StudentData(stdNo)));
	}

	@Override
	public void initList() { ///////////여기서  성적리스트 메서드 출력행햐ㅏ는거 아잉가
	list = service.showStudentScoreDatas();		
	}
	

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1,2,3,4,5,6,7,8,9,10);
			// 컬럼별 너비 조정
			setTableCellWidth(100, 100,20,100,50,50,50,50,50,20,20);
	}
///////////////////////////////////내용(학번당 ,성적) 담기
	@Override
	public Object[] toArray(StudentData t) { ///////여기서 수정해줘야할거같은
	String abc = null;
	double  s = 0;
	if (t.getTotal()/ 3 >90 && t.getTotal()/ 3 <101) {
		abc= "A";
		s = 4.5;
	}if (t.getTotal()/ 3 >80 && t.getTotal()/ 3 <91) {
		abc= "B";
		s = 3.5;
	}if (t.getTotal()/ 3 >70 && t.getTotal()/ 3 <81) {
		abc= "C";
		s = 2.5;
	}if (t.getTotal()/ 3 >60 && t.getTotal()/ 3 <71) {
		abc= "D";
		s = 1.5;
	}if (t.getTotal()/ 3 >=0 && t.getTotal()/ 3 <61) {
		abc= "F";
		s = 0;
	}
	//	System.out.printf("과목 1 : %d 과목2 : %d 과목 3 :%d",t.getSubject1(),t.getSubject2(),t.getSubject3()); // 모든 학번 출력된다.
		return  new Object[] {
				t.getStdNo(),t.getStdName(),t.getGrade(),t.getStdDepartment().getDeptName(),t.getSubject1(),t.getSubject2(),t.getSubject3(),t.getTotal(),t.toString5(),abc,s
		};
				
	}

	
	///////////////////////테이블 칼럼추가
	@Override
	public String[] getColumnNames() {
		return new String[] {"학번","이름","학년","학과","국어","영어","수학","총점","평균","평어","평점"};  //여기 갯수 수정해저ㅜ야한당
	}
	
	//////////////////////////////loadData
	public void loadData2(String where) {
		list =service.showStudentScoreByWhere(where);
		System.out.println(list+"<<list");
		setList();
	}
	

}
