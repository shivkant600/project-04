package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourseModel {
	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		 testsearch();
		// testfindbypk();
		//testfindbyname();
	}

	private static void testadd() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		// bean.setId(2);
		bean.setName("raju");
		bean.setDuration(" 7years");
		bean.setDescription("paper");
		bean.setCreatedBy("raju@gmai.com");
		bean.setModifiedBy("raju@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testupdate() throws Exception {
		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();

		bean.setId(2);
		bean.setName("aman");
		bean.setDuration("5 years");
		bean.setDescription("test");
		bean.setCreatedBy("aman@gmai.com");
		bean.setModifiedBy("aman@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {
		CourseModel model = new CourseModel();

		model.delete(2);

	}

	private static void testsearch() throws Exception {

		CourseBean bean = new CourseBean();
		CourseModel model = new CourseModel();
        // bean.setName("Bachelor of Arts");
		List list = model.search(bean,0,0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (CourseBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		
		}
	}

	private static void testfindbypk() throws Exception {

		int id = 1;

		CourseModel model = new CourseModel();

		CourseBean bean = model.findbyPk(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}
	}

	private static void testfindbyname() throws Exception {
		String name = "shivkant";

		CourseModel model = new CourseModel();

		CourseBean bean = model.findbyName(name);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDuration());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}
	}

}
