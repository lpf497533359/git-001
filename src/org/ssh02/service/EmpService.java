package org.ssh02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssh02.dao.EmpDao;
import org.ssh02.pojo.Emp;
@Service
@Transactional
public class EmpService {
	@Autowired
	private EmpDao ed;
	/**
	 * @return
	 * 查询所有带模糊查询
	 */
	public List<Emp> findAll(Emp emp) {
		String hql="from Emp where 1=1";
		if (emp!=null && emp.getDid()!=null) {
			hql+=" and did="+emp.getDid();
		}
		List<Emp> el=ed.findAll(hql);
		return el;
	}
	/**
	 * @param eid
	 * 删除
	 */
	public void deleteEmpWithEid(String eid) {
		ed.deleteEmpWithEid(eid);		
	}
	/**
	 * @param emp
	 * 添加
	 */
	public void save(Emp emp) {
		ed.save(emp);	
	}
	/**
	 * @param emp
	 * @return
	 * 修改之前查找到员工id,
	 */
	public Emp findEmpByBid(Emp emp) {	
		return ed.findEmpByEid(emp);
	}
	/**
	 * @param emp
	 * 根据员工Id修改员工信息
	 */
	public void update(Emp emp) {
		ed.update(emp);
		
	}
	public List<Emp> selectEmp(String ename, Integer did) {
		String sql="from Emp where 1=1";
		if (did!=null && did != 0) {
			sql+=" and dept.did="+did;
		}
		if (ename!=null && !ename.equals("")) {
			sql+=" and ename like '%"+ename+"%'";
		}
		sql+=" order by eid desc";
		List<Emp> listemp=ed.selectEmp(sql);
		return listemp;
	}

	

}
