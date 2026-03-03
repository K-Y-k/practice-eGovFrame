package egovframework.example.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.dept.dao.DeptDAO;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.vo.DeptVO;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	private final DeptDAO deptDAO;
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	
	
	@Override
	public String insertDept(DeptVO vo) throws Exception {
		return deptDAO.insertDept(vo);
	}


	@Override
	public List<?> selectDeptList(DeptVO vo) throws Exception {
		return deptDAO.selectDeptList(vo);
	}


	@Override
	public DeptVO selectDeptDetail(int deptno) throws Exception {
		return deptDAO.selectDeptail(deptno);
	}


	@Override
	public int deleteDept(int deptno) throws Exception {
		return deptDAO.deleteDept(deptno);
	}


	@Override
	public int updateDept(DeptVO vo) throws Exception {
		return deptDAO.updateDept(vo);
	}
	
}

