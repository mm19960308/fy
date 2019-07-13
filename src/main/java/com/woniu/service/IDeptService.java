package com.woniu.service;

import java.util.List;

import com.woniu.domain.Dept;
import com.woniu.domain.Page;

public interface IDeptService {
	void save(Dept d);
	void delete(Integer did);
	void update(Dept d);
	List<Dept> find();
	Dept find(Integer did);
	
	Page findPageData(int p, int size);
}
