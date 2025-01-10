package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.PurchaseBean;
import in.co.rays.model.PurchaseModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/PurchaseCtl", urlPatterns = { "/ctl/PurchaseCtl" })
public class PurchaseCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;

		String quantity = request.getParameter("quantity");
		if (DataValidator.isNull(quantity)) {
			request.setAttribute("quantity", PropertyReader.getValue("error.require", "quantity"));
			isValid = false;
		} else if (!DataValidator.isLong(quantity)) {
			request.setAttribute("quantity", "Invalid quantity");
			isValid = false;
		}

		String price = request.getParameter("price");
		if (DataValidator.isNull(price)) {
			request.setAttribute("price", PropertyReader.getValue("error.require", "price"));
			isValid = false;
		} else if (!DataValidator.isLong(price)) {
			request.setAttribute("price", "Invalid price");
			isValid = false;
		}

		String purchasedate = request.getParameter("purchasedate");
		if (DataValidator.isNull(purchasedate)) {
			request.setAttribute("purchasedate", PropertyReader.getValue("error.require", "purchasedate"));
			isValid = false;
		} else if (!DataValidator.isDate(purchasedate)) {
			request.setAttribute("purchasedate", "Invalid purchasedate");
			isValid = false;
		}

		if (DataValidator.isNull(request.getParameter("ordertype"))) {
			request.setAttribute("ordertype", PropertyReader.getValue("error.require", "ordertype"));
			isValid = false;
		}

		return isValid;

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		PurchaseBean bean = new PurchaseBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setQuantity(DataUtility.getInt(request.getParameter("quantity")));
		bean.setPrice(DataUtility.getLong(request.getParameter("price")));
		bean.setPurchasedate(DataUtility.getDate(request.getParameter("purchasedate")));

		bean.setOrdertype(DataUtility.getString(request.getParameter("ordertype")));
		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = DataUtility.getLong(request.getParameter("id"));
		PurchaseModel model = new PurchaseModel();

		if (id > 0) {

			try {
				PurchaseBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ServletUtility.forward(getView(), request, response);

		}

		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("op = " + op);

		PurchaseBean bean = (PurchaseBean) populateBean(request);
		PurchaseModel model = new PurchaseModel();
		try {
			if (OP_SAVE.equalsIgnoreCase(op)) {

				model.add(bean);

				ServletUtility.setSuccessMessage("Data Added Successfully..", request);

			}else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.PURCHASE_CTL, request, response);
				return;
			}
			
			if (OP_UPDATE.equalsIgnoreCase(op)) {
				
				
				model.update(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("Data Update Successfully..", request);
				
			}

			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("alerady exixts", request);
		}
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.PURCHASE_VIEW;
	}

}
