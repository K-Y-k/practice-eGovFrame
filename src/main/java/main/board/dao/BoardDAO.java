package main.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import main.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO {

	public String insertBoard(BoardVO vo) {
		return (String) insert("boardDAO.insertBoard", vo);
	}

	public List<?> selectBoardList(SampleDefaultVO searchVO) {
		return list("boardDAO.selectBoardList", searchVO);
	}

	public int selectBoardTotal(SampleDefaultVO searchVO) {
		return (int) select("boardDAO.selectBoardTotal", searchVO);
	}
	
	public BoardVO selectBoardDetail(int unq) {
		return (BoardVO) select("boardDAO.selectBoardDetail", unq);
	}

	public int updateBoardHits(int unq) {
		return update("boardDAO.updateBoardHits", unq);
	}

	/**
	 * 2026.01.13 (최초작성)
	 * 개발자 : 김용경
	 * 
	 * 2026.01.16 (수정처리)
	 * 개발자 : 홍길동
	 * 수정 사항 : 
	 */
	public int updateBoard(BoardVO vo) {
		return update("boardDAO.updateBoard", vo);
	}

	public int seletBoardPass(BoardVO vo) {
		return (int) select("boardDAO.selectBoardPass", vo);
	}

	public int deleteBoard(BoardVO vo) {
		return delete("boardDAO.deleteBoard", vo);
	}
	
}

