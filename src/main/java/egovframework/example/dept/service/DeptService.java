package egovframework.example.dept.service;

import java.util.List;

import egovframework.example.dept.vo.DeptVO;

public interface DeptService {
	public String insertDept(DeptVO vo) throws Exception;
	public List<?> selectDeptList(DeptVO vo) throws Exception;
	public DeptVO selectDeptDetail(int deptno) throws Exception;
	public int deleteDept(int deptno) throws Exception;
	public int updateDept(DeptVO vo) throws Exception;
}
