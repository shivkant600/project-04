package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.DocterBean;
import in.co.rays.model.DocterModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "DocterCtl", urlPatterns = { "/ctl/DocterCtl" })
public class DocterCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;
		return isValid;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DocterModel model = new DocterModel();

		Long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			try {

				DocterBean bean = model.findByPk(id);

				ServletUtility.setBean(bean, request);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DocterModel model = new DocterModel();

		DocterBean bean = (DocterBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		try {
			if (OP_SAVE.equalsIgnoreCase(op)) {
				model.add(bean);
				ServletUtility.setSuccessMessage("data added succesfully", request);

			}

			if (OP_UPDATE.equalsIgnoreCase(op)) {
				model.update(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("daTA UPDATED", request);
			}

			if (OP_CANCEL.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.DOCTER_CTL, request, response);
				return;

			}

			if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.DOCTER_CTL, request, response);
				return;
			}

		} catch (Exception e) {

		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		DocterBean bean = new DocterBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setmobile(DataUtility.getString(request.getParameter("mobile")));
		bean.setexperties(DataUtility.getString(request.getParameter("experties")));
		return bean;

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.Docter_view;
	}

}
