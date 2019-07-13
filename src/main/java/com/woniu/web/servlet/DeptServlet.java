package com.woniu.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.domain.Dept;
import com.woniu.domain.Page;
import com.woniu.service.IDeptService;
import com.woniu.service.impl.DeptServiceImpl;

public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDeptService service = new DeptServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("save".equals(method)) {
			save(request,response);
		} else if("findAll".equals(method)) {
			findAll(request, response);
		} else if("delete".equals(method)) {
			delete(request, response);
		} else if("updateUI".equals(method)) {
			updateUI(request, response);
		} else if("update".equals(method)) {
			update(request, response);
		}
		
		
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer did = Integer.parseInt(request.getParameter("did"));
		String dname = request.getParameter("dname");
		Dept d = new Dept();
		d.setDid(did);
		d.setDname(dname);
		
		service.update(d);
		
		response.sendRedirect("DeptServlet.do?method=findAll");
		
	}

	private void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer did = Integer.parseInt(request.getParameter("did"));
		Dept dept = service.find(did);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/dept/updateUI.jsp").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer did = Integer.parseInt(request.getParameter("did"));
		service.delete(did);
		
		response.sendRedirect("DeptServlet.do?method=findAll");
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ss = request.getParameter("p");
		if(ss == null) {
			ss = "1";
		}
		
		Integer p = Integer.parseInt(ss);
		
		Page page = service.findPageData(p, 5);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/dept/findAllUI.jsp").forward(request, response);
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dname = request.getParameter("dname");
		Dept d = new Dept();
		d.setDname(dname);
		
		service.save(d);
		
		response.sendRedirect("DeptServlet.do?method=findAll");
		
	}

}
