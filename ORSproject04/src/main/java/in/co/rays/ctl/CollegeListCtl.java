package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "CollegeListCtl", urlPatterns = { "/ctl/CollegeListCtl" })
public class CollegeListCtl extends BaseCtl {

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		CollegeBean bean = new CollegeBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("Name")));

		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CollegeBean> list = null;
		List<CollegeBean> next = null;

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		CollegeModel model = new CollegeModel();
		CollegeBean bean = (CollegeBean) populateBean(request);

		try {
			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextListSize", next.size());

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CollegeBean> list = null;
		List<CollegeBean> next = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("op = " + op);

		String[] ids = request.getParameterValues("ids");

		CollegeModel model = new CollegeModel();
		CollegeBean bean = (CollegeBean) populateBean(request);

		try {
			if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				for (String id : ids) {

					model.delete(DataUtility.getLong(id));

				}
			}

			if (OP_SEARCH.equalsIgnoreCase(op)) {
				pageNo = 1;

			}

			if (OP_NEW.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.COLLEGE_CTL, request, response);
				return;

			}

			if (OP_NEXT.equalsIgnoreCase(op)) {
				pageNo++;
			}
			if (OP_PREVIOUS.equalsIgnoreCase(op)) {
				pageNo--;
			}

			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo, pageSize);
			request.setAttribute("nextListSize", next.size());
			ServletUtility.setBean(bean, request);
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		return ORSView.COLLEGE_LIST_VIEW;
	}

}
