package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.util.JDBCDataSource;

public class CourseModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_course");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id == " + pk);
		}
		return pk + 1;
	}

	public void add(CourseBean bean) throws Exception {

		CourseBean exitsbean = findbyName(bean.getName());

		if (exitsbean != null) {
			throw new Exception("course name already exits");
		}

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?,?,?,?,?,?,?,?)");

		pstmt.setLong(1, nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDuration());
		pstmt.setString(4, bean.getDescription());
		pstmt.setString(5, bean.getCreatedBy());
		pstmt.setString(6, bean.getModifiedBy());
		pstmt.setTimestamp(7, bean.getCreatedDatetime());
		pstmt.setTimestamp(8, bean.getModifiedDatetime());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted " + i);
	}

	public void update(CourseBean bean) throws Exception {

		CourseBean existBean = findbyName(bean.getName());

		if (existBean != null && bean.getId() != existBean.getId()) {
			throw new Exception("course name already exist..!!");
		}

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update St_course set name=?,duration =?,description =?,created_by =?,modified_by=?,created_datetime=?,modified_datetime=? where id =?");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDuration());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedBy());
		pstmt.setString(5, bean.getModifiedBy());
		pstmt.setTimestamp(6, bean.getCreatedDatetime());
		pstmt.setTimestamp(7, bean.getModifiedDatetime());

		pstmt.setLong(8, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated succesfully" + i);

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id =?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted " + i);
	}

	public List search(CourseBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_course where 1 = 1");
		
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "'");
			}
		}
		
		
		
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}


		
		
		
		System.out.println("sql="+sql.toString());
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new CourseBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

			list.add(bean);

		}
		return list;

	}

	public CourseBean findbyPk(long id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where id = ?");

		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		CourseBean bean = null;

		while (rs.next()) {
			bean = new CourseBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

		}
		return bean;

	}

	public CourseBean findbyName(String name) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_course where name = ?");

		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		CourseBean bean = null;

		while (rs.next()) {
			bean = new CourseBean();

			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));

		}
		return bean;
	}

}