package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.PurchaseBean;
import in.co.rays.model.PurchaseModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/PurchaseListCtl", urlPatterns = { "/ctl/PurchaseListCtl" })
public class PurchaseListCtl extends BaseCtl {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PurchaseModel model = new PurchaseModel();

		PurchaseBean bean = new PurchaseBean();

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

		PurchaseModel model = new PurchaseModel();
		PurchaseBean bean = new PurchaseBean();

		try {
			if (OP_DELETE.equalsIgnoreCase(op)) {
				for (String id : ids) {

					model.delete(DataUtility.getInt(id));
					List list = model.search(bean, 0, 0);
					ServletUtility.setList(list, request);
				}
			}
			if (OP_NEW.equalsIgnoreCase(op)) {
				
				ServletUtility.redirect(ORSView.PURCHASE_CTL, request, response);
				return;
				
			}
			
			ServletUtility.forward(getView(), request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		return ORSView.PURCHASE_LIST_VIEW;
	}

}