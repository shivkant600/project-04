package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "CollegeCtl", urlPatterns = { "/ctl/CollegeCtl" })
public class CollegeCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean isValid = true;

		// Validate First Name
		String Name = request.getParameter("Name");
		if (DataValidator.isNull(Name)) {
			request.setAttribute("Name", PropertyReader.getValue("error.require", "Name"));
			isValid = false;
		} else if (!DataValidator.isName(Name)) {
			request.setAttribute("Name", "Invalid  Name");
			isValid = false;

		}

		String Address = request.getParameter("Address");
		if (DataValidator.isNull(Address)) {
			request.setAttribute("Address", PropertyReader.getValue("error.require", "Address"));
			isValid = false;
		} else if (!DataValidator.isName(Address)) {
			request.setAttribute("Address", "Invalid  Address");
			isValid = false;

		}

		String State = request.getParameter("State");
		if (DataValidator.isNull(State)) {
			request.setAttribute("State", PropertyReader.getValue("error.require", "State"));
			isValid = false;
		} else if (!DataValidator.isName(State)) {
			request.setAttribute("State", "Invalid  State");
			isValid = false;

		}

		String City = request.getParameter("City");
		if (DataValidator.isNull(City)) {
			request.setAttribute("City", PropertyReader.getValue("error.require", "City"));
			isValid = false;
		} 

		String PhoneNo = request.getParameter("PhoneNo");
		if (DataValidator.isNull(PhoneNo)) {
			request.setAttribute("PhoneNo", PropertyReader.getValue("error.require", "Phone No"));
			isValid = false;
		} else if (!DataValidator.isPhoneLength(PhoneNo)) {
			request.setAttribute("PhoneNo", "PhoneNo No must have 10 digits");
			isValid = false;
		} else if (!DataValidator.isPhoneNo(PhoneNo)) {
			request.setAttribute("PhoneNo", "Invalid Phone No");
			isValid = false;
		}

		return isValid;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		CollegeBean bean = new CollegeBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("Name")));
		bean.setAddress(DataUtility.getString(request.getParameter("Address")));
		bean.setState(DataUtility.getString(request.getParameter("State")));
		bean.setCity(DataUtility.getString(request.getParameter("City")));
		bean.setPhoneNo(DataUtility.getString(request.getParameter("PhoneNo")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = DataUtility.getLong(request.getParameter("id"));
		CollegeModel model  = new CollegeModel();
		
		if (id > 0) {
			try {
				CollegeBean bean  = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		System.out.println("op = " + op);

		CollegeModel model = new CollegeModel();
		CollegeBean bean = (CollegeBean) populateBean(request);
		try {
			if (OP_SAVE.equalsIgnoreCase(op)) {

				model.add(bean);

				ServletUtility.setSuccessMessage("Data Added Successsfully", request);
				ServletUtility.forward(getView(), request, response);
			}
			
			if (OP_UPDATE.equalsIgnoreCase(op)) {
				
				model.update(bean);
				ServletUtility.setSuccessMessage("Data Update Successfully..", request);
			}

			if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.COLLEGE_CTL, request, response);
				return;

			}
			
		} catch (Exception e) {

			ServletUtility.setBean(bean, request);

			ServletUtility.setErrorMessage("Invalid Data", request);
			ServletUtility.forward(getView(), request, response);
		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		return ORSView.COLLEGE_VIEW;
	}

}
