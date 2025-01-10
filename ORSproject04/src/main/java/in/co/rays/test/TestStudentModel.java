package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();
//		testdelete();
		testsearch();
//		testfindByPk();
//		testfindbyemail();

	}

	private static void testfindbyemail() throws Exception {

		String email = "sandeep@gmail.com";

		StudentModel model = new StudentModel();

		StudentBean bean = model.findByEmail(email);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testfindByPk() throws Exception {

		long id = 1;

		StudentModel model = new StudentModel();

		StudentBean bean = model.findByPk(id);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");
		}

	}

	private static void testsearch() throws Exception {

		StudentBean bean = new StudentBean();

		StudentModel model = new StudentModel();

		bean.setFirstName("Ankit");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getCollegeId());
			System.out.print("\t" + bean.getCollegeName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testdelete() throws Exception {

		StudentModel model = new StudentModel();
		model.delete(1);

	}

	private static void testupdate() throws Exception {

		StudentBean bean = new StudentBean();

		bean.setId(1);
		bean.setFirstName("goutam");
		bean.setLastName("gurjar");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("90483943");
		bean.setEmail("sandeep@gmail.com");
		bean.setCollegeId(2);
		bean.setCreatedBy("mohit");
		bean.setModifiedBy("mohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();
		model.update(bean);

	}

	private static void testadd() throws Exception {

		StudentBean bean = new StudentBean();

		bean.setId(1);
		bean.setFirstName("sandeep");
		bean.setLastName("gurjar");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("90483943");
		bean.setEmail("sandeep@gmail.com");
		bean.setCollegeId(2);
		bean.setCreatedBy("mohit");
		bean.setModifiedBy("mohit");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		StudentModel model = new StudentModel();

		model.add(bean);

	}

}
