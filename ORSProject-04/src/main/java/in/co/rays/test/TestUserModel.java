package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();

		// testdelete();

		// testsearch();

		// findbylogin();
		//testfindbypk();
		testAuthenticate();

	}

	
	private static void testadd() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		// bean.setId(2);
		bean.setFirstName("nikhil");
		bean.setLastName("patel");
		bean.setLogin("nikhil@gmail.com");
		bean.setPassword("550");
		bean.setDob(new Date());
		bean.setMobileNo("555");
		bean.setRoleId(3);
		bean.setGender("male");
		bean.setCreatedBy("nikhil@gmail.com");
		bean.setModifiedBy("nikhil@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(2);
		bean.setFirstName("anmol");
		bean.setLastName("agrawal");
		bean.setLogin("anmol@gmail.com");
		bean.setPassword("9876");
		bean.setDob(new Date());
		bean.setMobileNo("789400");
		bean.setRoleId(3);
		bean.setGender("male");
		bean.setCreatedBy("anmol@gmail.com");
		bean.setModifiedBy("anmol@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();

		model.delete(2);

	}

	private static void testsearch() throws Exception {
		
		

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		//bean.setFirstName("ravi");
		List list = model.search(bean,0,0);

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

	private static void findbylogin() throws Exception {

		String login = "shiv@gmail.com";

		UserModel model = new UserModel();

		UserBean bean = model.findbylogin(login);

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

	private static void testfindbypk() throws Exception {
		int id = 1;
		UserModel model = new UserModel();

		UserBean bean = model.findybpk(id);

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
	
	
	private static void testAuthenticate() throws Exception {
	UserModel model = new UserModel();
	
	UserBean bean = model.authneticate("ravisharma@gmail.com","password123");
	
	
	if(bean != null) {
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
	else {
		System.out.println("user not found");
	}
	}


}
