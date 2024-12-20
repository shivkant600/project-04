package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.SubjectBean;
import in.co.rays.bean.TimeTableBean;
import in.co.rays.model.SubjectModel;
import in.co.rays.model.TimeTableModel;

public class TestTimeTable {
	public static void main(String[] args) throws Exception {

		//testadd();
		//testupdate();
		//testdelete();
		testsearch();
		//testfindbyPk();
	}

	
	private static void testadd() throws Exception {
		TimeTableBean bean = new TimeTableBean();

		TimeTableModel model = new TimeTableModel();

		//bean.setId(3);
		bean.setSemester("paper");
		bean.setDescription("5rd");
		bean.setExamDate(new Date());
		bean.setExamTime("11:00AM - 12:00PM");
		bean.setCourseId(3);
		bean.setSubjectId(2);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testupdate() throws Exception {

		TimeTableBean bean = new TimeTableBean();

		TimeTableModel model = new TimeTableModel();

		bean.setId(2);
		bean.setSemester("midsem");
		bean.setDescription("6th");
		bean.setExamDate(new Date());
		bean.setExamTime("10:00AM - 11:00PM");
		bean.setCourseId(2);
		bean.setSubjectId(1);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	private static void testdelete() throws Exception {

		long id = 1;
		TimeTableModel model = new TimeTableModel();

		model.delete(3);

	}

	private static void testsearch() throws Exception {
		TimeTableBean bean = new TimeTableBean();

		TimeTableModel model = new TimeTableModel();
		bean.setSemester("Semester 2");

		List list = model.search(bean,0,0);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (TimeTableBean) it.next();

			System.out.println(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}
	
	private static void testfindbyPk() throws Exception {
		
		long id = 2;
		TimeTableBean bean  =new TimeTableBean();
		
		TimeTableModel model = new TimeTableModel();
		
		bean  = model.findbyPk(id);
		
		
		if(bean != null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
			
			
		}else {
			System.out.println("id not found");
		}
		
	}


}
