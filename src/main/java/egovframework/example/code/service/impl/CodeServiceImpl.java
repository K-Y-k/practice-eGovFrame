package egovframework.example.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.code.dao.CodeDAO;
import egovframework.example.code.service.CodeService;
import egovframework.example.code.vo.CodeVO;

@Service("codeService")
public class CodeServiceImpl implements CodeService {

	@Resource(name="codeDAO")
	private CodeDAO codeDAO;
	
	@Override // 다형성(오버라이딩)
	public String insertCode(CodeVO vo) throws Exception {
		return codeDAO.insertCodes(vo);
	}
	
	@Override
	public CodeVO selectCodesDeatil(int code) throws Exception {
		return codeDAO.selectCodesDetail(code);
	}

	@Override
	public List<?> selectCodesList(CodeVO vo) throws Exception {
		return codeDAO.selectCodesList(vo);
	}

	@Override
	public int selectCodesCount(CodeVO vo) throws Exception {
		return codeDAO.selectCodesCount(vo);
	}

	@Override
	public int deleteCodes(int code) throws Exception {
		return codeDAO.deleteCodes(code);
	}

	@Override
	public int updateCodes(CodeVO vo) throws Exception {
		return codeDAO.updateCodes(vo);
	}


}
