package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

		testadd();
//		testdelete();
//		testupdate();
//		testsearch();
//		testfindbypk();
//		testfindbyname();

	}

	private static void testfindbyname() throws Exception {

		String name = "student";
		RoleModel model = new RoleModel();

		RoleBean bean = model.findByName(name);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
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

		long id = 5;

		RoleModel model = new RoleModel();

		RoleBean bean = model.findByPk(id);
		if (bean != null) {

//			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
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

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean.setName("admin");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (RoleBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getDescription());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testdelete() throws Exception {

		RoleModel model = new RoleModel();

		model.delete(3);

	}

	private static void testupdate() throws Exception {

		RoleBean bean = new RoleBean();

		bean.setId(1);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("student@gmail.com");
		bean.setModifiedBy("student@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();
		model.update(bean);

	}

	private static void testadd() throws Exception {

		RoleBean bean = new RoleBean();

		bean.setName("kiousak");
		bean.setDescription("kiousak");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();
		model.add(bean);

	}
}
