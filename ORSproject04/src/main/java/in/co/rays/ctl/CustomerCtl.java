package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CustomerBean;
import in.co.rays.model.CustomerModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "CustomerCtl", urlPatterns = { "/ctl/CustomerCtl" })
public class CustomerCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		boolean isValid = true;

		// Validate First Name
		String ClientName = request.getParameter("ClientName");
		if (DataValidator.isNull(ClientName)) {
			request.setAttribute("ClientName", PropertyReader.getValue("error.require", " ClientName"));
			isValid = false;
		} else if (!DataValidator.isName(ClientName)) {
			request.setAttribute("ClientName", "Invalid clientName");
			isValid = false;
		}

		// Validate Last Name
		String Location = request.getParameter("Location");
		if (DataValidator.isNull(Location)) {
			request.setAttribute("Location", PropertyReader.getValue("error.require", "Location "));
			isValid = false;
		} else if (!DataValidator.isName(Location)) {
			request.setAttribute("Location", "Invalid location");
			isValid = false;
		}

		// Validate Mobile No
		String Number = request.getParameter("Number");
		if (DataValidator.isNull(Number)) {
			request.setAttribute("Number", PropertyReader.getValue("error.require", "Number No"));
			isValid = false;
		} else if (!DataValidator.isPhoneLength(Number)) {
			request.setAttribute("Number", "Mobile No must have 10 digits");
			isValid = false;
		} else if (!DataValidator.isPhoneNo(Number)) {
			request.setAttribute("Number", "Invalid Mobile No");
			isValid = false;
		}

		String Importance = request.getParameter("Importance");
		if (DataValidator.isNull(Importance)) {
			request.setAttribute("Importance", PropertyReader.getValue("error.require", "Importance "));
			isValid = false;
		}

		return isValid;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomerModel model = new CustomerModel();
		CustomerBean bean = (CustomerBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));

		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);

				ServletUtility.setSuccessMessage("data added succesfully", request);
				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		CustomerBean bean = new CustomerBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setClientName(DataUtility.getString(request.getParameter("ClientName")));
		bean.setLocation(DataUtility.getString(request.getParameter("Location")));
		bean.setNumber(DataUtility.getString(request.getParameter("Number")));
		bean.setImportance(DataUtility.getString(request.getParameter("Importance")));
		return bean;

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CUSTOMER_VIEW;
	}

}
