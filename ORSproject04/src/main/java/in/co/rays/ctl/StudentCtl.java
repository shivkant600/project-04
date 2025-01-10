package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.RoleModel;
import in.co.rays.model.StudentModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "StudentCtl", urlPatterns = { "/ctl/StudentCtl" })
public class StudentCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;

		// Validate First Name
		String firstname = request.getParameter("firstname");
		if (DataValidator.isNull(firstname)) {
			request.setAttribute("firstname", PropertyReader.getValue("error.require", "First Name"));
			isValid = false;
		} else if (!DataValidator.isName(firstname)) {
			request.setAttribute("firstname", "Invalid First Name");
			isValid = false;
		}

		// Validate Last Name
		String lastname = request.getParameter("lastname");
		if (DataValidator.isNull(lastname)) {
			request.setAttribute("lastname", PropertyReader.getValue("error.require", "Last Name"));
			isValid = false;
		} else if (!DataValidator.isName(lastname)) {
			request.setAttribute("lastname", "Invalid Last Name");
			isValid = false;
		}

		// Validate Gender
		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			isValid = false;
		}

		// Validate Date of Birth
		String dob = request.getParameter("dob");
		if (DataValidator.isNull(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Date of Birth"));
			isValid = false;
		} else if (!DataValidator.isDate(dob)) {
			request.setAttribute("dob", PropertyReader.getValue("error.date", "Date of Birth"));
			isValid = false;
		}

		// Validate Mobile No
		String mobileno = request.getParameter("mobileno");
		if (DataValidator.isNull(mobileno)) {
			request.setAttribute("mobileno", PropertyReader.getValue("error.require", "Mobile No"));
			isValid = false;
		} else if (!DataValidator.isPhoneLength(mobileno)) {
			request.setAttribute("mobileno", "Mobile No must have 10 digits");
			isValid = false;
		} else if (!DataValidator.isPhoneNo(mobileno)) {
			request.setAttribute("mobileno", "Invalid Mobile No");
			isValid = false;
		}

		// Validate email
		String email = request.getParameter("email");
		if (DataValidator.isNull(email)) {
			request.setAttribute("email", PropertyReader.getValue("error.require", "email Id"));
			isValid = false;
		} else if (!DataValidator.isEmail(email)) {
			request.setAttribute("email", PropertyReader.getValue("error.email", "  Email"));
			isValid = false;
		}
		
		// Validate collegename
				String collegeId = request.getParameter("collegeId");
				if (DataValidator.isNull(collegeId)) {
					request.setAttribute("collegeId", PropertyReader.getValue("error.require", "collegeName"));
					isValid = false;
				}

		return isValid;
	}

	@Override
	protected void preload(HttpServletRequest request) {
		CollegeModel collegemodel = new CollegeModel();
		try {
			List collegeList = collegemodel.list();
			request.setAttribute("collegeList", collegeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		StudentBean bean = new StudentBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstname")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastname")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileno")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setCollegeId(DataUtility.getLong(request.getParameter("collegeId")));

		populateDTO(bean, request);
		return bean;
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
		System.out.println("op = " + op);

		StudentBean bean = (StudentBean) populateBean(request);

		StudentModel model = new StudentModel();
		try {

			if (OP_SAVE.contentEquals(op)) {

				model.add(bean);
				ServletUtility.setSuccessMessage("Data Added Successfully..", request);
				ServletUtility.forward(getView(), request, response);
			}
			
			if (OP_RESET.equalsIgnoreCase(op)) {
				
				ServletUtility.redirect(ORSView.STUDENT_CTL, request, response);
				return;
			}

		} catch (Exception e) {

			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Email Already Exist..", request);
			ServletUtility.forward(getView(), request, response);

			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		return ORSView.STUDENT_VIEW;
	}

}
