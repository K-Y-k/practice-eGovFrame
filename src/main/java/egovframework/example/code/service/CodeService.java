package egovframework.example.code.service;

import java.util.List;

import egovframework.example.code.vo.CodeVO;

public interface CodeService {
	
	public String insertCode(CodeVO vo) throws Exception;
	public CodeVO selectCodesDeatil(int code) throws Exception;
	public List<?> selectCodesList(CodeVO vo) throws Exception;
	public int selectCodesCount(CodeVO vo) throws Exception;
	public int deleteCodes(int code) throws Exception;
	public int updateCodes(CodeVO vo) throws Exception;
	
}
