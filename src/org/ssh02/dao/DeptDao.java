package org.ssh02.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.ssh02.pojo.Dept;
@Repository
public class DeptDao {
	@Resource
	private SessionFactory sf;
	public List<Dept> findAll() {
		Session session = sf.openSession();
		String sql="select * from dept";
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		sqlQuery.addEntity(Dept.class);
		List d1=sqlQuery.list();
		return d1;
	}

}
