package com.woniu.service;

import java.util.List;

import com.woniu.domain.Emp;
import com.woniu.domain.Page;

public interface IEmpService {
	void save(Emp e);
	void delete(Integer eid);
	void update(Emp e);
	List<Emp> find();
	Emp find(Integer eid);
	
	Page findPageData(int p, int size);
}
