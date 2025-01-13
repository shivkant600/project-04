package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CustomerBean;
import in.co.rays.model.CustomerModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "CustomerListCtl", urlPatterns = { "/ctl/CustomerListCtl" })
public class CustomerListCtl extends BaseCtl {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = null;

		CustomerBean bean = new CustomerBean();
		CustomerModel model = new CustomerModel();

		try {
			list = model.search(bean, 0, 0);
			ServletUtility.setList(list, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String op = DataUtility.getString(request.getParameter("operation"));
		String[] ids = request.getParameterValues("ids");

		CustomerModel model = new CustomerModel();
		CustomerBean bean = (CustomerBean) populateBean(request);
		try {

			for (String id : ids) {
				model.delete(DataUtility.getInt(id));
				List list = model.search(bean, 0, 0);
				ServletUtility.setList(list, request);
				ServletUtility.forward(getView(), request, response);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(OP_SEARCH.equalsIgnoreCase(op)) {
			try {
			List list =	model.search(bean, 0, 0);
			ServletUtility.setList(list, request);
			ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerBean bean = new CustomerBean();
		bean.setImportance(DataUtility.getString("Importance"));
		return bean;

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CUSTOMER_LIST_VIEW;
	}

}
