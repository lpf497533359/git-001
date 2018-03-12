package org.ssh02.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.ssh02.pojo.Emp;
@Repository
public class EmpDao extends HibernateDaoSupport{
	@Autowired
	public void set(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	/**
	 * @param hql
	 * @return
	 * 查询EMP
	 */
	public List<Emp> findAll(String hql) {
		HibernateTemplate jdbc=this.getHibernateTemplate();
		List<Emp> el=(List<Emp>) jdbc.find(hql);
		return el;
	}
	/**
	 * @param eid
	 * 根据eid删除
	 */
	public void deleteEmpWithEid(String eid) {
		HibernateTemplate jdbc=this.getHibernateTemplate();
		Emp emp=new Emp();
		emp.setEid(Integer.valueOf(eid));
		jdbc.delete(emp);
	}
	/**
	 * @param emp
	 * 添加
	 */
	public void save(Emp emp) {
		HibernateTemplate jdbc=this.getHibernateTemplate();
		jdbc.save(emp);
	}
	/**
	 * @param emp
	 * @return
	 * 修改之前查找到员工id,
	 */
	public Emp findEmpByEid(Emp emp) {
		HibernateTemplate jdbc=this.getHibernateTemplate();
		emp=jdbc.get(Emp.class,emp.getEid());
		return emp;
	}
	/**
	 * @param emp
	 * 根据员工Id修改员工信息
	 */
	public void update(Emp emp) {
		HibernateTemplate jdbc=this.getHibernateTemplate();
		jdbc.saveOrUpdate(emp);
		
	}
	public List<Emp> selectEmp(String sql) {
		HibernateTemplate jdbc=getHibernateTemplate();
		List<Emp> emp=(List<Emp>) jdbc.find(sql);
		return emp;
	}

}
