package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.ClientBean;
import in.co.rays.util.JDBCDataSource;

public class ClientModel {

	public void add(ClientBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_client values(?, ?, ?, ?, ?)");

		pstmt.setLong(1, nextpk());
		pstmt.setString(2, bean.getFullName());
		pstmt.setDate(3, new Date(bean.getAppointmentDate().getTime()));
		pstmt.setString(4, bean.getPhoneNo());
		pstmt.setString(5, bean.getIllness());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data added succefully =  " + i);

	}

	public void update(ClientBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_clent  full_name = ?, appoinment_date = ?, phone_no = ?, illness = ?,where id = ?");

		pstmt.setString(2, bean.getFullName());
		pstmt.setDate(3, new Date(bean.getAppointmentDate().getTime()));
		pstmt.setString(4, bean.getPhoneNo());
		pstmt.setString(5, bean.getIllness());

		pstmt.setLong(1, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data update successfully = " + i);

	}

	public void delete(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_client where id = ?");

		pstmt.setLong(1, id);

		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);

		System.out.println("data delete successfully = " + i);
	}

	public List list() throws Exception {
		return search(null, 0, 0);
	}

	public List search(ClientBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_client where 1 = 1");

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		System.out.println("sql = " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new ClientBean();

			bean.setId(rs.getLong(1));
			bean.setFullName(rs.getString(2));
			bean.setAppointmentDate(rs.getDate(3));
			bean.setPhoneNo(rs.getString(4));
			bean.setIllness(rs.getString(5));

			list.add(bean);

		}

		JDBCDataSource.closeConnection(conn);
		return list;

	}

	public int nextpk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_client");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
			System.out.println("max id =  " + pk);
		}
		return pk + 1;
	}

	public ClientBean findByPk(long id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_client where id=?");
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		ClientBean bean = null;

		while (rs.next()) {

			bean = new ClientBean();

			bean.setId(rs.getLong(1));
			bean.setFullName(rs.getString(2));
			bean.setAppointmentDate(rs.getDate(3));
			bean.setPhoneNo(rs.getString(4));
			bean.setIllness(rs.getString(5));

		}

		JDBCDataSource.closeConnection(conn);
		return bean;
	}

}
