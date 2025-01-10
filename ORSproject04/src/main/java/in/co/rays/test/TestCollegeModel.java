package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();
//		testdelete();
		testsearch();
//		testfindbyname();
//		testfindbypk();

	}

	private static void testfindbypk() throws Exception {

		long id = 2;

		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findByPk(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddress());
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

	private static void testfindbyname() throws Exception {

		String name = "RITS";

		CollegeModel model = new CollegeModel();

		CollegeBean bean = model.findByName(name);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddress());
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

	private static void testsearch() throws Exception {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		bean.setName("Sunrise College");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CollegeBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getAddress());
			System.out.println("\t" + bean.getState());
			System.out.println("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testdelete() throws Exception {

		CollegeModel model = new CollegeModel();
		model.delete(1);

	}

	private static void testupdate() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setId(2);
		bean.setName("RITS");
		bean.setAddress("indore");
		bean.setState("mp");
		bean.setCity("indore");
		bean.setPhoneNo("98897876");
		bean.setCreatedBy("sandeep");
		bean.setModifiedBy("sandeepg");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();
		model.update(bean);

	}

	private static void testadd() throws Exception {

		CollegeBean bean = new CollegeBean();

		bean.setId(2);
		bean.setName("LNCTS");
		bean.setAddress("indore");
		bean.setState("mp");
		bean.setCity("indore");
		bean.setPhoneNo("98897876");
		bean.setCreatedBy("sandeep");
		bean.setModifiedBy("sandeepg");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		CollegeModel model = new CollegeModel();

		model.add(bean);

	}

}
