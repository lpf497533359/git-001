package org.ssh02.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssh02.pojo.Dept;
import org.ssh02.service.DeptService;

@Controller
@CrossOrigin("*")
public class DeptController {
	@Resource
	private DeptService ds;
	@RequestMapping(value="/listDept",method=RequestMethod.POST)
	@ResponseBody
	public List<Dept> fn1(){
		List<Dept> d1=ds.findAll();
		return d1;
	}
	
	
}
