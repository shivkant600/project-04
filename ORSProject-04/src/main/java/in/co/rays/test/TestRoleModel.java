package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		 testsearch();

		// testfindbypk();
		//testfindbyname();

	}

	private static void testadd() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		// bean.setId(2);
		bean.setName("kiousk");
		bean.setDescription("kiousk");
		bean.setCreatedBy("kiousk@gmail.com");
		bean.setModifiedBy("kiousk@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testupdate() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean.setName("manager");
		bean.setDescription("manager");
		bean.setCreatedBy("admin2@gmail.com");
		bean.setModifiedBy("admin2@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(2);

		model.update(bean);

	}

	private static void testdelete() throws Exception {

		RoleModel model = new RoleModel();

		model.delete(1);

	}

	private static void testsearch() throws Exception {
		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		List list = model.search(bean,0,0);

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

	private static void testfindbypk() throws Exception {

		long id = 1;

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean = model.findByPk(1);

		if (bean != null) {

			System.out.println(bean.getId());
			;
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

	private static void testfindbyname() throws Exception {
		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		String name = "student";

		bean = model.findbyname(name);

		if (bean != null) {

			System.out.println(bean.getId());
			;
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

}
