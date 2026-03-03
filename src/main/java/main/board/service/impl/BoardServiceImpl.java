package main.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.SampleDefaultVO;
import main.board.dao.BoardDAO;
import main.board.service.BoardService;
import main.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO boardDAO;
	
	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	

	@Override
	public String insertBoard(BoardVO vo) throws Exception {
		return boardDAO.insertBoard(vo);
	}


	@Override
	public List<?> selectBoardList(SampleDefaultVO searchVO) throws Exception {
		return boardDAO.selectBoardList(searchVO);
	}


	@Override
	public int selectBoardTotal(SampleDefaultVO vo) throws Exception {
		return boardDAO.selectBoardTotal(vo);
	}


	@Override
	public BoardVO selectBoardDetail(int unq) throws Exception {
		return boardDAO.selectBoardDetail(unq);
	}


	@Override
	public int updateBoardHits(int unq) throws Exception {
		return boardDAO.updateBoardHits(unq);
	}


	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		return boardDAO.updateBoard(vo);
	}


	@Override
	public int selectBoardPass(BoardVO vo) throws Exception {
		return boardDAO.seletBoardPass(vo);
	}


	@Override
	public int deleteBoard(BoardVO vo) throws Exception {
		return boardDAO.deleteBoard(vo);
	}

}
