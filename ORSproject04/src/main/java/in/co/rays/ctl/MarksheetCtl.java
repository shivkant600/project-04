package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;
import in.co.rays.model.StudentModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "/MarksheetCtl", urlPatterns = {"/ctl/MarksheetCtl"})
public class MarksheetCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean isValid = true;
		
		String rollno = request.getParameter("rollno");
		if (DataValidator.isNull(rollno)) {
			request.setAttribute("rollno", PropertyReader.getValue("error.require", "RollNo"));
			isValid = false;
			
		}
		
		String studentid = request.getParameter("studentid");
		if (DataValidator.isNull(studentid)) {
			request.setAttribute("studentid", PropertyReader.getValue("error.require", "StudentName"));
			isValid = false;
		}
		
		String physics = request.getParameter("physics");
		if (DataValidator.isNull(physics)) {
			request.setAttribute("physics", PropertyReader.getValue("error.require", "Physics"));
			isValid = false;
		}
		
		String chemistry = request.getParameter("chemistry");
		if (DataValidator.isNull(chemistry)) {
			request.setAttribute("chemistry", PropertyReader.getValue("error.require", "Chemistry"));
			isValid = false;
		} 
		
		String maths = request.getParameter("maths");
		if (DataValidator.isNull(maths)) {
			request.setAttribute("maths", PropertyReader.getValue("error.require", "Maths"));
			isValid = false;
		} 
		
		return isValid;
	}
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setRollNo(DataUtility.getString(request.getParameter("rollno")));
		bean.setStudentId(DataUtility.getLong(request.getParameter("studentid")));
		bean.setPhysics(DataUtility.getInt(request.getParameter("physics")));
		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));
		
		populateDTO(bean, request);
		
		return bean;
	}
	
	@Override
	protected void preload(HttpServletRequest request) {

		StudentModel model = new StudentModel();
		
		try {
			List studentlist = model.list();
			request.setAttribute("studentlist", studentlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = (MarksheetBean) populateBean(request);
		try {
		if (OP_SAVE.equalsIgnoreCase(op)) {
	
				model.add(bean);
				ServletUtility.setSuccessMessage("Data Added Successfully...", request);

		}
		
		if (OP_RESET.equalsIgnoreCase(op)) {
			
			ServletUtility.redirect(getView(), request, response);
		}
			} catch (Exception e) {
//				e.printStackTrace();
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Rollno Allready Exist...", request);
			}
		ServletUtility.forward(getView(), request, response);
	}
	
	@Override
	protected String getView() {
		return ORSView.MARKSHEET_VIEW;
	}

}


