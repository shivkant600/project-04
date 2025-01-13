package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CustomerBean;
import in.co.rays.util.JDBCDataSource;

public class CustomerModel {

	public void add(CustomerBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_customer values(?, ?, ?, ?, ?)");

		pstmt.setLong(1, nextpk());
		pstmt.setString(2, bean.getClientName());
		pstmt.setString(3, bean.getLocation());
		pstmt.setString(4, bean.getNumber());
		pstmt.setString(5, bean.getImportance());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data added succefully =  " + i);

	}

	public void update(CustomerBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_customer set clientname = ?, location = ?, number = ?, importance = ? where id = ?");

		pstmt.setString(1, bean.getClientName());
		pstmt.setString(2, bean.getLocation());
		pstmt.setString(3, bean.getNumber());
		pstmt.setString(4, bean.getImportance());

		pstmt.setLong(5, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data update successfully = " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_customer where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);

		System.out.println("data delete successfully = " + i);
	}

	public List list() throws Exception {
		return search(null, 0, 0);
	}

	public List search(CustomerBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_customer where 1 = 1");

		if (bean != null) {
			if (bean.getImportance() != null && bean.getImportance().length() > 0) {
				sql.append(" and importance like '" + bean.getImportance() + "'");
			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		System.out.println("sql = " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new CustomerBean();

			bean.setId(rs.getLong(1));
			bean.setClientName(rs.getString(2));
			bean.setLocation(rs.getString(3));
			bean.setNumber(rs.getString(4));
			bean.setImportance(rs.getString(5));

			list.add(bean);

		}

		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public int nextpk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_customer");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
			System.out.println("max id =  " + pk);
		}
		return pk + 1;
	}

	public CustomerBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_customer where id=?");
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		CustomerBean bean = null;

		while (rs.next()) {

			bean = new CustomerBean();

			bean.setId(rs.getLong(1));
			bean.setClientName(rs.getString(2));
			bean.setLocation(rs.getString(3));
			bean.setNumber(rs.getString(4));
			bean.setImportance(rs.getString(5));

		}

		JDBCDataSource.closeConnection(conn);
		return bean;
	}

}
