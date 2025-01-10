package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "RoleListCtl", urlPatterns = { "/ctl/RoleListCtl" })
public class RoleListCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		return true;
	}

	@Override
	protected void preload(HttpServletRequest request) {

		RoleModel model = new RoleModel();

		List roleList;
		try {
			roleList = model.list();
			request.setAttribute("roleList", roleList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		RoleBean bean = new RoleBean();

		bean.setName(DataUtility.getString(request.getParameter("Name")));
		bean.setId(DataUtility.getLong(request.getParameter("roleId")));
		return bean;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<RoleBean> list = null;
		List<RoleBean> next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
		
		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;


		RoleBean bean = (RoleBean) populateBean(request);
		RoleModel model = new RoleModel();

		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("op = " + op);

		String[] ids = request.getParameterValues("ids");

		try {
			if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;

				for (String id : ids) {

					model.delete(Integer.parseInt(id));

				}

			}

			if (OP_SEARCH.equalsIgnoreCase(op)) {
				pageNo = 1;

				model.search(bean, 0, 0);

			}

			if (OP_NEW.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
				return;

			}

			if (OP_NEXT.equalsIgnoreCase(op)) {

				pageNo++;

			} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
				pageNo--;
			}

			ServletUtility.setBean(bean, request);

			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextListSize", next.size());

			ServletUtility.setBean(bean, request);
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<UserBean> list = null;
		List<UserBean> next = null;

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));


		RoleModel model = new RoleModel();
		RoleBean bean = (RoleBean) populateBean(request);

		try {
			 list = model.search(bean,pageNo, pageSize);
			 next = model.search(bean,pageNo + 1, pageSize);
			 
			 request.setAttribute("nextListSize", next.size());
				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				ServletUtility.forward(getView(), request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	@Override
	protected String getView() {
		return ORSView.ROLE_LIST_VIEW;
	}

}
