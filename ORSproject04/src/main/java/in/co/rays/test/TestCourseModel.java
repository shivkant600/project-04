package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourseModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();
//		testdelete();
		testsearch();
//		testfindbypk();
//		testfindbyname();

	}

	private static void testfindbyname() throws Exception {

		String name = "mathscience";

		CourseModel model = new CourseModel();

		CourseBean bean = model.findByName(name);

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

	private static void testfindbypk() throws Exception {

		long id = 1;

		CourseModel model = new CourseModel();

		CourseBean bean = model.findByPk(id);

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

	private static void testsearch() throws Exception {

		CourseBean bean = new CourseBean();

		CourseModel model = new CourseModel();

		bean.setName("Diploma in Engineering");

		List list = model.search(bean, 0, 0);

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

	private static void testdelete() throws Exception {

		CourseModel model = new CourseModel();
		model.delete(1);

	}

	private static void testupdate() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(1);
		bean.setName("commerce");
		bean.setDuration("4yaer");
		bean.setDescription("lnctscollege");
		bean.setCreatedBy("sandeep");
		bean.setModifiedBy("sandeepgurjar");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();

		model.update(bean);

	}

	private static void testadd() throws Exception {

		CourseBean bean = new CourseBean();

		bean.setId(1);
		bean.setName("mathscience");
		bean.setDuration("4yaer");
		bean.setDescription("lnctscollege");
		bean.setCreatedBy("sandeep");
		bean.setModifiedBy("sandeepgurjar");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CourseModel model = new CourseModel();
		model.add(bean);

	}

}
