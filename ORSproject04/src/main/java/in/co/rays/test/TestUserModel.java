package in.co.rays.test;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;
import in.co.rays.util.JDBCDataSource;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testadd();
//		testupdate();
//		testdelete();
//		testsearch();
//		testfindbylogin();
//		testfindbypk();
//		testauthenticate();

	}

	private static void testauthenticate() throws Exception {

		String login = "meenabhardwaj@gmail.com";
		String password = "password123";

		UserModel model = new UserModel();

		UserBean bean = model.authenticate(login, password);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getLogin());
			System.out.println("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not available");

		}

	}

	private static void testfindbypk() throws Exception {

		long id = 1;

		UserModel model = new UserModel();
		UserBean bean = model.findByPk(id);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getLogin());
			System.out.println("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testfindbylogin() throws Exception {

		String login = "sawan@gmail.com";

		UserModel model = new UserModel();

		UserBean bean = model.findByLogin(login);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getLogin());
			System.out.println("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		} else {

			System.out.println("user not found");

		}

	}

	private static void testsearch() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setFirstName("Meena");

		List list = model.search(bean, 0, 0);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getFirstName());
			System.out.println("\t" + bean.getLastName());
			System.out.println("\t" + bean.getLogin());
			System.out.println("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.println("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getRoleId());
			System.out.println("\t" + bean.getGender());
			System.out.println("\t" + bean.getCreatedBy());
			System.out.println("\t" + bean.getModifiedBy());
			System.out.println("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

	private static void testdelete() throws Exception {

		UserModel model = new UserModel();
		model.delete(0);

	}

	private static void testupdate() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstName("Aman");
		bean.setLastName("Gupta");
		bean.setLogin("sawan@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setMobileNo("9998890811");
		bean.setRoleId(1);
		bean.setGender("male");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testadd() throws Exception {

		UserBean bean = new UserBean();

//		bean.setId(1);
		bean.setFirstName("Prabhakar");
		bean.setLastName("Mandloi");
		bean.setLogin("prabhakar@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setMobileNo("9998890811");
		bean.setRoleId(2);
		bean.setGender("male");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.add(bean);

	}

}
