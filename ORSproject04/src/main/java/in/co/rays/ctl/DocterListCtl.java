package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.DocterBean;
import in.co.rays.model.DocterModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "DocterListCtl", urlPatterns = { "/ctl/DocterListCtl" })
public class DocterListCtl extends BaseCtl {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DocterBean bean = new DocterBean();
		DocterModel model = new DocterModel();
		try {
			List list = model.search(bean, 0, 0);
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

		String op = DataUtility.getString(request.getParameter("operation"));

		String[] ids = request.getParameterValues("ids");

		DocterBean bean = (DocterBean) populateBean(request);
		DocterModel model = new DocterModel();

		try {

			if (OP_DELETE.equalsIgnoreCase(op)) {
				for (String id : ids) {
					model.delete(DataUtility.getLong(id));

					List list = model.search(bean, 0, 0);
					ServletUtility.setList(list, request);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.DOCTER_LIST_VIEW;
	}

}
