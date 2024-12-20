package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;
import in.co.rays.util.JDBCDataSource;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		 testsearch();
		// testfindbyPk();
		//testfindbyRollNo();
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		//bean.setId(2);
		bean.setRollNo("101");
		bean.setStudentId(1);
		bean.setPhysics(55);
		bean.setChemistry(70);
		bean.setMaths(80);
		bean.setCreatedBy("shiv@gmail.com");
		bean.setModifiedBy("shiv@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		bean.setId(1);
		bean.setRollNo("101");
		bean.setStudentId(2);
		bean.setPhysics(55);
		bean.setChemistry(70);
		bean.setMaths(80);
		bean.setCreatedBy("shiv@gmail.com");
		bean.setModifiedBy("shiv@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	private static void testdelete() throws Exception {
		MarksheetModel model = new MarksheetModel();

		model.delete(2);

	}

	private static void testsearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();
		//bean.setName("Ankit Sharma");

		List list = model.search(bean,0,0);

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

	private static void testfindbyPk() throws Exception {

		long id = 1;
		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findbyPk(1);

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
			System.out.println("id not found");
		}

	}

	private static void testfindbyRollNo() throws Exception {

		String rollNo = "101";

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByRollNo(rollNo);

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
			System.out.println("roll no not found");
		}

	}

}
