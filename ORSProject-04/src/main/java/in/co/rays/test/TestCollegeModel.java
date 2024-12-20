package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.CourseBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {
	

	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		 testSearch();
		//testfindbyname();
		// testfindbyPk();
	}

	private static void testadd() throws Exception {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		// bean.setId(1);
		bean.setName("anshit");
		bean.setAddrss("jabalpur");
		bean.setState("mp");
		bean.setCity("bhopal");
		bean.setPhoneNo("74777");
		bean.setCreatedBy("anshit@gmail.com");
		bean.setModifiedBy("anshit@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));

		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	public static void testupdate() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setId(2);
		bean.setName("aman");
		bean.setAddrss("noida");
		bean.setState("up");
		bean.setCity("gwalior");
		bean.setPhoneNo("548788");
		bean.setCreatedBy("aman@gamil.com");
		bean.setModifiedBy("aman@gamil.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	private static void testdelete() throws Exception {
		CollegeModel model = new CollegeModel();

		model.delete(3);

	}

	private static void testSearch() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
      //   bean.setName("arya college");
		List list = model.search(bean,0,0);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (CollegeBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddrss());
			System.out.println("\t" + bean.getState());
			System.out.println("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}
	}

	private static void testfindbyname() throws Exception {

		String name = "shivkant";
		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findbyName(name);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddrss());
			System.out.println("\t" + bean.getState());
			System.out.println("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {
			System.out.println("user not found");
		}
	}

	private static void testfindbyPk() throws Exception {
		int id = 1;

		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findbypk(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddrss());
			System.out.println("\t" + bean.getState());
			System.out.println("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("user not found");
		}

	}

}
