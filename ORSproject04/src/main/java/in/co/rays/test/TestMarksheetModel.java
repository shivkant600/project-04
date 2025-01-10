package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();
//		testdelete();
		testsearch();
//		testfindbypk();
//		testfindbyrollNo(); 
	}

	private static void testfindbyrollNo() throws Exception {

		String roll_no = "CE201";

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByRollNo(roll_no);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testfindbypk() throws Exception {

		long id = 1;

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPk(id);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testsearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		bean.setName("Ankit Sharma");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getStudentId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testdelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(1);

	}

	private static void testupdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(2);
		bean.setRollNo("CE201");
		bean.setStudentId(1);
		bean.setName("sandeep");
		bean.setPhysics(98);
		bean.setChemistry(76);
		bean.setMaths(80);
		bean.setCreatedBy("mohit");
		bean.setModifiedBy("goutam");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();

		model.update(bean);

	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(1);
		bean.setRollNo("CE201");
		bean.setStudentId(1);
		bean.setName("sandeep");
		bean.setPhysics(98);
		bean.setChemistry(76);
		bean.setMaths(90);
		bean.setCreatedBy("mohit");
		bean.setModifiedBy("goutam");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

}
