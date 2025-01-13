package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.ClientBean;
import in.co.rays.model.ClientModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "ClientCtl", urlPatterns = { "/ctl/ClientCtl" })
public class ClientCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;
		// validate full name
		String fullName = request.getParameter("fullName");
		if (DataValidator.isNull(fullName)) {
			request.setAttribute("fullName", PropertyReader.getValue("error.require", "fullName"));
			isValid = false;

		} else if (!DataValidator.isName(fullName)) {
			request.setAttribute("fullName", "Invalid Full Name");
			isValid = false;
		}

		// Validate appoinmettdate
		String dob = request.getParameter("appoinmetDate");
		if (DataValidator.isNull(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "appoinmetDate"));
			isValid = false;
		} else if (!DataValidator.isDate(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.date", "appoinmetDate"));
			isValid = false;
		}

		// Validate Mobile No
		String phoneNo = request.getParameter("phoneNo");
		if (DataValidator.isNull(phoneNo)) {
			request.setAttribute("phoneNo", PropertyReader.getValue("error.require", "phone No"));
			isValid = false;
		} else if (!DataValidator.isPhoneLength(phoneNo)) {
			request.setAttribute("phoneNo", "phone No must have 10 digits");
			isValid = false;
		} else if (!DataValidator.isPhoneNo(phoneNo)) {
			request.setAttribute("PhoneNo", "Invalid Mobile No");
			isValid = false;
		}

		// Validate illness
		String illness = request.getParameter("illness");
		if (DataValidator.isNull(illness)) {
			request.setAttribute("illness", PropertyReader.getValue("error.require", "illness"));
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
		String op = DataUtility.getString(request.getParameter("operation"));

		ClientModel model = new ClientModel();

		ClientBean bean = (ClientBean) populateBean(request);

		try {

			if (OP_SAVE.equalsIgnoreCase(op)) {
				model.add(bean);
				ServletUtility.setSuccessMessage("data added succesfully", request);
			}

			if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.CLIENT_CTL, request, response);
				return;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		ClientBean bean = new ClientBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFullName(DataUtility.getString(request.getParameter("fullName")));
		bean.setAppointmentDate(DataUtility.getDate(request.getParameter("appoinmetDate")));
		bean.setPhoneNo(DataUtility.getString(request.getParameter("phoneNo")));
		bean.setIllness(DataUtility.getString(request.getParameter("illness")));
		return bean;

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CLIENT_VIEW;
	}

}
