package com.woniu.web.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.domain.Emp;
import com.woniu.domain.Page;
import com.woniu.service.IDeptService;
import com.woniu.service.IEmpService;
import com.woniu.service.impl.DeptServiceImpl;
import com.woniu.service.impl.EmpServiceImpl;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDeptService is = new DeptServiceImpl();
	private IEmpService ie = new EmpServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String method = request.getParameter("method");
		if("save".equals(method)) {
			save(request,response);
		} else if("findAll".equals(method)) {
			findAll(request,response);
		} else if("delete".equals(method)) {
			delete(request,response);
		} else if("update".equals(method)) {
			update(request,response);
		} else if("updateUI".equals(method)) {
			updateUI(request,response);
		}  
	}

	private void updateUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer eid = Integer.parseInt(request.getParameter("eid"));

		Emp emp = ie.find(eid);
		
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/emp/updateUI.jsp").forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Emp emp = new Emp();
			Integer eid = Integer.parseInt(request.getParameter("eid"));

			String ename = request.getParameter("ename");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date hiredate = sdf.parse(request.getParameter("hiredate"));
			Double sal = Double.parseDouble(request.getParameter("sal"));
			Integer did = Integer.parseInt(request.getParameter("did"));
			emp.setDid(did);
			emp.setEname(ename);
			emp.setHiredate(hiredate);
			emp.setSal(sal);
			emp.setEid(eid);
			
			ie.update(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		response.sendRedirect("EmpServlet.do?method=findAll");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer eid = Integer.parseInt(request.getParameter("eid"));
		
		ie.delete(eid);
		
		response.sendRedirect("EmpServlet.do?method=findAll");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("p");
		if(p == null) {
			p = "1";
		}
		Integer s = Integer.parseInt(p);

		Page page=ie.findPageData(s, 5);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/emp/findAllUI.jsp").forward(request, response);;
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Emp emp = new Emp();
			String ename = request.getParameter("ename");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date hiredate = sdf.parse(request.getParameter("hiredate"));
			Double sal = Double.parseDouble(request.getParameter("sal"));
			Integer did = Integer.parseInt(request.getParameter("did"));
			emp.setDid(did);
			emp.setEname(ename);
			emp.setHiredate(hiredate);
			emp.setSal(sal);
			ie.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		response.sendRedirect("EmpServlet.do?method=findAll");
	}

}
