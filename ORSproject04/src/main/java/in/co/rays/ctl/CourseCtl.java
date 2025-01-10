package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "CourseCtl", urlPatterns = { "/ctl/CourseCtl" })
public class CourseCtl extends BaseCtl {

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

		String Duration = request.getParameter("Duration");
		if (DataValidator.isNull(Name)) {
			request.setAttribute("Duration", PropertyReader.getValue("error.require", "Duration"));
			isValid = false;
		}
		String Description = request.getParameter("Description");
		if (DataValidator.isNull(Name)) {
			request.setAttribute("Description", PropertyReader.getValue("error.require", "Description"));
			isValid = false;
		} else if (!DataValidator.isName(Name)) {
			request.setAttribute("Description", "Invalid  Description");
			isValid = false;

		}

		return isValid;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		CourseBean bean = new CourseBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("Name")));
		bean.setDuration(DataUtility.getString(request.getParameter("Duration")));
		bean.setDescription(DataUtility.getString(request.getParameter("Description")));

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

		CourseBean bean = (CourseBean) populateBean(request);
		
		System.out.println("op =" + op);

		CourseModel model = new CourseModel();
		
		try {
			if (OP_SAVE.equalsIgnoreCase(op)) {

				model.add(bean);
				ServletUtility.setSuccessMessage("Data Add Successfully..", request);
				ServletUtility.forward(getView(), request, response);

			}

			if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.COURSE_CTL, request, response);
				return;
			}

		} catch (Exception e) {
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Name Already exist", request);
			ServletUtility.forward(getView(), request, response);
		}
		
//		ServletUtility.forward(getView(), request, response);
		

	}

	@Override
	protected String getView() {

		return ORSView.COURSE_VIEW;
	}

}
