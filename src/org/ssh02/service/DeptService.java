package org.ssh02.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssh02.dao.DeptDao;
import org.ssh02.pojo.Dept;
@Service
@Transactional
public class DeptService {
	@Resource
	private DeptDao dd;
	public List<Dept> findAll() {	
		return dd.findAll();
	}

	
	
}
