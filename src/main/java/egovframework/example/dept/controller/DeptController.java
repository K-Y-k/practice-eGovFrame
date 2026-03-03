package egovframework.example.dept.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.vo.DeptVO;

@Controller
public class DeptController {
	
	private final DeptService deptService;
	
	@Autowired
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	/**
	 * 작성 폼
	 */
	@RequestMapping(value="/deptWrite.do")
	public String deptWriteForm() {
		return "dept/deptWrite";
	}

	/**
	 * 저장 기능
	 */
	@RequestMapping(value="/deptWriteSave.do")
	public String deptWriteSave(DeptVO vo) throws Exception {
		
		System.out.println("부서번호 : " + vo.getDeptno());
		System.out.println("부서이름 : " + vo.getDname());
		System.out.println("부서위치 : " + vo.getLoc());
		
		String result = deptService.insertDept(vo);
		if (Objects.isNull(result)) {
			System.out.println("저장 완료");
		} else {
			System.out.println("저장 실패");
		}
		
		return "";
	}
	
	/**
	 * 목록 리스트
	 */
	@RequestMapping(value="/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception {
		
		List<?> list = deptService.selectDeptList(vo);
		System.out.println(list);
		
		model.addAttribute("resultList", list);
		
		return "dept/deptList";
	}
	
	
	/**
	 * 상세 조회
	 */
	@RequestMapping(value="/deptDetail")
	public String selectDeptDetail(int deptno, ModelMap model) throws Exception {
		
		DeptVO vo = deptService.selectDeptDetail(deptno);
		System.out.println("부서번호:" + vo.getDeptno());
		
		model.addAttribute("result", vo);
		
		return "dept/deptDetail";
	}
	
	/**
	 * 삭제 기능
	 */
	@RequestMapping(value="/deptDelete.do")
	public String deleteDept(int deptno) throws Exception {

		int result = deptService.deleteDept(deptno);			
		if (result == 1) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
		
		return "";
	}
	
	/**
	 * 수정 폼
	 */
	@RequestMapping(value="/deptModifyWrite.do")
	public String selectDeptModify(int deptno, ModelMap model) throws Exception {
		DeptVO result = deptService.selectDeptDetail(deptno);
		model.addAttribute("result", result);
		return "dept/deptModifyWrite";
	}
	
	/**
	 * 수정 기능
	 */
	@RequestMapping(value="/deptModifySave.do")
	public String updateDept(DeptVO vo) throws Exception {
		
		int result = deptService.updateDept(vo);
		if (result == 1) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패");
		}
		
		return "";
	}
	
}
