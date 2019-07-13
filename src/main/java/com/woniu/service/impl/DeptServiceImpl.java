package com.woniu.service.impl;

import java.util.List;

import com.woniu.dao.IDeptDao;
import com.woniu.dao.impl.DeptDaoImpl;
import com.woniu.domain.Dept;
import com.woniu.domain.Page;
import com.woniu.service.IDeptService;

public class DeptServiceImpl implements IDeptService {
	private IDeptDao dao = new DeptDaoImpl();
	public void save(Dept d) {
		dao.save(d);
	}
	
	public void delete(Integer did) {
		dao.delete(did);
	}

	public void update(Dept d) {
		dao.update(d);
	}

	public List<Dept> find() {
		return dao.find();
	}

	@Override
	public Dept find(Integer did) {
		return dao.find(did);
	}

	@Override
	public Page findPageData(int p, int size) {
		int rc = dao.getRowCount();
		Page<Dept> page = new Page<Dept>(p, rc, size);
		List<Dept> list = dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
