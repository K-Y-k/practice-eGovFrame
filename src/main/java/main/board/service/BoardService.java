package main.board.service;

import java.util.List;

import egovframework.example.sample.service.SampleDefaultVO;
import main.board.vo.BoardVO;

public interface BoardService {
	
	public String insertBoard(BoardVO vo) throws Exception;
	public List<?> selectBoardList(SampleDefaultVO searchVO) throws Exception;
	public int selectBoardTotal(SampleDefaultVO vo) throws Exception;
	public BoardVO selectBoardDetail(int unq) throws Exception;
	public int updateBoardHits(int unq) throws Exception;
	public int updateBoard(BoardVO vo) throws Exception;
	public int selectBoardPass(BoardVO vo) throws Exception;
	public int deleteBoard(BoardVO vo) throws Exception;
	
}
