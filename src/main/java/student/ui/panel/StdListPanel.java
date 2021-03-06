package student.ui.panel;

import javax.swing.SwingConstants;

import student.dto.StudentData;
import student.service.StudentDataService;
import student.ui.exception.NotSelectedException;
import student.ui.list.AbstractCustomTablePanel;

@SuppressWarnings("serial")
public class StdListPanel extends AbstractCustomTablePanel<StudentData> {
	StudentDataService service;

	public StdListPanel() {
	service = new StudentDataService();
	}

	@Override
	public StudentData getItem() {
		int row = table.getSelectedRow();
		if(row == -1) {
			throw new NotSelectedException();
		}
		int stdNo =(int)table.getValueAt(row, 0);
		System.out.println(""+list.get(list.indexOf(new StudentData(stdNo))));
		return list.get(list.indexOf(new StudentData(stdNo)));
		
	}

	@Override
	public void initList() {
	list =service.showStudentDatas();		
	}
	

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1,2,3,4,5,6,7);
			// 컬럼별 너비 조정
			setTableCellWidth(100,100,100,20,20,20,20,20);
	}

	@Override
	public Object[] toArray(StudentData t) {
		
		return new Object[] {t.getStdNo(),t.getStdName(),t.getStdDepartment().toString(),t.getGrade(),t.getStdState().toString(),t.getMilitaryState().toString(),t.getDayNightShift(), t.toString7()};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"학번","이름","학과","학년","학적상태","병역상태","주야구분","사진"};
	}
	public void loadData2(String where) {
		list =service.showStudentDataByWhere(where);
		setList();
	}
}
