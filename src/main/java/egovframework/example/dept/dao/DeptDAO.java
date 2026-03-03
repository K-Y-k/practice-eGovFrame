package egovframework.example.dept.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.dept.vo.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {

	public String insertDept(DeptVO vo) throws Exception {
		return (String) insert("deptDAO.insertDept", vo);
	}

	public List<?> selectDeptList(DeptVO vo) {
		return list("deptDAO.selectDeptList", vo);
	}

	public DeptVO selectDeptail(int deptno) {
		return (DeptVO) select("deptDAO.selectDetail", deptno);
	}

	public int deleteDept(int deptno) {
		return delete("deptDAO.deleteDept", deptno);
	}

	public int updateDept(DeptVO vo) {
		return update("deptDAO.updateDept", vo);
	}

}

