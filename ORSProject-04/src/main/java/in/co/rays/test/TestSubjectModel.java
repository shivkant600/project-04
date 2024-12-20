package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.SubjectBean;
import in.co.rays.model.SubjectModel;

public class TestSubjectModel {

	public static void main(String[] args) throws Exception {

		//testadd();
		// testUpdate();
		// testdelete();
		// testFindByPk();
		// testFindByName();

		testSearch();
	}

	private static void testadd() throws Exception {
		SubjectBean bean = new SubjectBean();

		SubjectModel model = new SubjectModel();

		//bean.setId(2);
		bean.setName("electrical");
		bean.setCourseId(1);
		bean.setDescription("civil");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testUpdate() throws Exception {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();

		bean.setId(2);
		bean.setName("physics");
		bean.setCourseId(3);
		bean.setDescription("electrical");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testdelete() throws Exception {
		SubjectModel model = new SubjectModel();

		model.delete(1);

	}

	private static void testFindByPk() throws Exception {
		long id = 1;
		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findbyPk(id);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found");
		}
	}

	private static void testFindByName() throws Exception {
		String name = "physics";

		SubjectModel model = new SubjectModel();

		SubjectBean bean = model.findbyName(name);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testSearch() throws Exception {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
        //  bean.setName("Physics");
		List list = model.search(bean,0,0);
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (SubjectBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());

		}

	}

}
