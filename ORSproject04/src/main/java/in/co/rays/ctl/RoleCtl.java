package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "RoleCtl", urlPatterns = { "/ctl/RoleCtl" })
public class RoleCtl extends BaseCtl {

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

		// Validate First Name
		String description = request.getParameter("description");
		if (DataValidator.isNull(description)) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "description"));
			isValid = false;
		} else if (!DataValidator.isName(description)) {
			request.setAttribute("description", "Invalid  description");
			isValid = false;

		}
		return isValid;

	}
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
	
	RoleBean bean = new RoleBean();
	
	bean.setId(DataUtility.getLong(request.getParameter("id")));
	
	bean.setName(DataUtility.getString(request.getParameter("Name")));
	bean.setDescription(DataUtility.getString(request.getParameter("description")));
	
	populateDTO(bean, request);
	
	return bean;
	
	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		Long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0) {

			RoleModel model = new RoleModel(); 

			try {
				RoleBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RoleBean bean = (RoleBean) populateBean(request);
		
		String op = DataUtility.getString(request.getParameter("operation"));
		
		System.out.println("op = " + op);
		
		RoleModel model = new RoleModel();
		
		if (OP_SAVE.equalsIgnoreCase(op)) {
			
			try {
				model.add(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ServletUtility.forward(getView(), request, response);
			
		}else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		}
		

		if (OP_UPDATE.equalsIgnoreCase(op)) {
			
			try {
				model.update(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ServletUtility.forward(getView(), request, response);
			
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		}
		
		
		
		
		
	}

	@Override
	protected String getView() {
		return ORSView.ROLE_VIEW;
	}

}
