package com.woniu.service.impl;

import java.util.List;

import com.woniu.dao.IEmpDao;
import com.woniu.dao.impl.EmpDaoImpl;
import com.woniu.domain.Emp;
import com.woniu.domain.Page;
import com.woniu.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	private IEmpDao empdao = new EmpDaoImpl();
	public void save(Emp e) {
		empdao.save(e);
	}

	public void delete(Integer eid) {
		empdao.delete(eid);
	}

	public void update(Emp e) {
		empdao.update(e);
	}

	public List<Emp> find() {
		return empdao.find();
	}

	public Emp find(Integer eid) {
		return empdao.find(eid);
	}

	public Page findPageData(int p, int size) {
		int rowCount = empdao.getRowCount();
		Page<Emp> page = new Page<>(p, rowCount,size);
		List<Emp> list = empdao.find(page.getStartLine(), size);
		page.setList(list);
		return page;
	}

}
