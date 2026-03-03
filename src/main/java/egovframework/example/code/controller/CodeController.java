package egovframework.example.code.controller;

import java.util.List;
import java.util.Objects;
import org.springframework.ui.ModelMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.code.service.CodeService;
import egovframework.example.code.vo.CodeVO;

@Controller
public class CodeController {
	
	private final CodeService codeService;
	
	@Autowired
	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}
	
	
	/**
	 * 코드 작성 폼
	 */
	@RequestMapping(value="/codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}

	/**
	 * 코드 저장 기능
	 */
	@RequestMapping(value="/codeWriteSave.do")
	public String insertCode(CodeVO vo) throws Exception {
		
		// insert 성공한 경우 -> String result = null
		// insert 실패한 경우 -> 오류 발생
		String result = codeService.insertCode(vo);
		if (Objects.isNull(result)) {
			System.out.println("저장완료");
		}
		
		return "redirect:codeList.do";
	}
	
	
	/**
	 * 코드 목록
	 */
	@RequestMapping(value="/codeList.do")
	public String selectCodesList(CodeVO vo, ModelMap model) throws Exception {
		
		List<?> resultList = codeService.selectCodesList(vo);
		System.out.println(resultList);
		
		int total = codeService.selectCodesCount(vo);
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultTotal", total);
		
		return "code/codeList";
	}
	
	/**
	 * 삭제 기능
	 */
	@RequestMapping(value="/codeDelete.do")
	public String deleteCodes(int code) throws Exception {
		
		int result = codeService.deleteCodes(code);
		if (result == 1) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
		
		return "redirect:codeList.do";
	}
	
	/**
	 * 수정 폼
	 */
	@RequestMapping(value="/codeModifyWrite.do")
	public String updateCodesForm(int code, ModelMap model) throws Exception {
		
		CodeVO vo = codeService.selectCodesDeatil(code);
		System.out.println(vo);
		model.addAttribute("result", vo);
		
		return "code/codeModifyWrite";
	}
	
	/**
	 * 수정 기능
	 */
	@RequestMapping(value="/codeUpdate.do")
	public String updateCodes(CodeVO vo, ModelMap model) throws Exception {
		System.out.println("code = " + vo.getCode());
	    System.out.println("gid = " + vo.getGid());
	    System.out.println("name = " + vo.getName());
		
		int result = codeService.updateCodes(vo);
		if (result == 1) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패");
		}
		
		return "redirect:codeList.do";
	}
	
}
