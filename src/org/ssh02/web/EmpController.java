package org.ssh02.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssh02.pojo.Emp;
import org.ssh02.service.EmpService;

import com.sun.org.apache.regexp.internal.recompile;

import sun.security.x509.EDIPartyName;

@Controller
@CrossOrigin("*")
public class EmpController {
	@Autowired
	private EmpService es;
	/**
	 * @param response
	 * @param emp
	 * @return
	 * ��ѯ����
	 */
	@RequestMapping(value="/listEmp",method=RequestMethod.POST)
	@ResponseBody
	public List<Emp> fn1(Emp emp){
		List<Emp> e1=es.findAll(emp);
		return e1;
	}
	/**
	 * @param response
	 * @param eid
	 * @return
	 * ɾ��
	 */
	@RequestMapping(value="/delete/{eid}",method=RequestMethod.POST)
	@ResponseBody
	public String fn2(HttpServletResponse response,@PathVariable("eid") String eid){
	
		es.deleteEmpWithEid(eid);
		return "{}";
	}
	
	/**
	 * @param emp
	 * @return
	 * ���
	 */
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	@ResponseBody
	public String fn2(Emp emp) {
		es.save(emp);
		return "{}";
	}
	/**
	 * @param emp
	 * @return
	 * �޸�֮ǰ���ҵ�Ա��id,
	 */
	@RequestMapping(value="/toupdateEmp",method=RequestMethod.POST)
	@ResponseBody
	public Emp fn3(Emp emp){
		emp=es.findEmpByBid(emp);
		return emp;
	}
	/**
	 * @param emp
	 * ����Ա��Id�޸�Ա����Ϣ
	 */
	@RequestMapping(value="/updateEmp",method=RequestMethod.POST)
	@ResponseBody
	public String fn4(Emp emp){
		es.update(emp);
		return "{}";
	}
	@RequestMapping(value="/selectEmp",method=RequestMethod.POST)
	@ResponseBody
	public List<Emp> selectEmp(HttpServletResponse response,String ename,Integer did){
		List<Emp> selectemp =es.selectEmp(ename,did);
		return selectemp;
	}
	
	
}
