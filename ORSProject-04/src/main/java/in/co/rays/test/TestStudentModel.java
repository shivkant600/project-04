package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();

		// testdelete();
		testsearch();
		// findbypk();
		// findbyEmail();
	}

	private static void testadd() throws Exception {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		// bean.setId(2);
		bean.setFirstName("sandep");
		bean.setLastName("patel");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("7477252349");
		bean.setEmail("shiv@gmail.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("shiv");
		bean.setModifiedBy("shiv");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testupdate() throws Exception {

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		bean.setId(1);
		bean.setFirstName("aman");
		bean.setLastName("patel");
		bean.setDob(new Date());
		bean.setGender("male");
		bean.setMobileNo("7477252349");
		bean.setEmail("shiv@gmail.com");
		bean.setCollegeId(2);
		bean.setCreatedBy("shiv");
		bean.setModifiedBy("shiv");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {

		StudentModel model = new StudentModel();

		model.delete(2);

	}

	private static void testsearch() throws Exception {

		StudentBean bean = new StudentBean();

		StudentModel model = new StudentModel();
		//bean.setFirstName("aman");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (StudentBean) it.next();
			System.out.println(bean.getId());
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

	private static void findbypk() throws Exception {

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

		}

	}

	private static void findbyEmail() throws Exception {
		String email = "aman@gmail.com";
		StudentModel model = new StudentModel();

		StudentBean bean = model.findbyEmai(email);

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

		}

	}

}
