package main.board.controller;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import main.board.service.BoardService;
import main.board.vo.BoardVO;

@Controller
public class BoardController {
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name="boardService")
	private BoardService boardService;
	
	
	/**
	 * 게시물 작성 폼
	 */
	@RequestMapping("/boardWrite.do")
	public String boardWirte() {
		return "board/boardWrite";
	}
	
	
	/**
	 * 작성 기능
	 */
	@ResponseBody // 반환을 뷰가 아닌 데이터를 전송해야 하는 경우 사용해야하는 어노테이션
	@RequestMapping("/boardWriteSave.do")
	public String insertBoard(BoardVO vo) throws Exception {
		
		System.out.println(vo);
		
		String result = boardService.insertBoard(vo);
		return (Objects.isNull(result)) ? "ok" : "fail";
	}
	
	/**
	 * 게시물 목록
	 */
	@RequestMapping("/boardList.do")
	public String selectBoardList(BoardVO vo, SampleDefaultVO sampleVO, ModelMap model) throws Exception {
		
		System.out.println("searchCondition: " + sampleVO.getSearchCondition());
		System.out.println("keyword: " + sampleVO.getSearchKeyword());
		
		// 페이지당 데이터 제한할 개수
		int unit = sampleVO.getPageUnit();
		
		// 총 데이터 개수
	    int totCnt = boardService.selectBoardTotal(sampleVO);
		// 총 페이지 개수
		int totalPage = (int) Math.ceil((double)totCnt / unit);
		
		// 현재 페이지 및 조건 처리
	    int viewPage = sampleVO.getPageIndex();
	    if (viewPage > totalPage || viewPage < 1) {
	    	viewPage = 1;
	    }

	    // 시작 인덱스 값을 MySQL OFFSET은 0부터라서 unit-1을 하면 안됨
	    int startIndex = (viewPage - 1) * unit;
	    
	    sampleVO.setFirstIndex(startIndex);
	    sampleVO.setRecordCountPerPage(unit);

	    // 게시판 리스트
	    List<?> resultList = boardService.selectBoardList(sampleVO);
		System.out.println("list: " + resultList);
		System.out.println("pageIndex: " + sampleVO.getPageIndex());

		// 시작 페이지, 끝 페이지
	    int startRowNum = totCnt - (viewPage - 1) * unit;

	    model.addAttribute("rowNumber", startRowNum);
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("total", totCnt);
	    model.addAttribute("totalPage", totalPage);

		return "board/boardList";
	}
	
	/**
	 * 상세 조회 폼
	 */
	@RequestMapping("/boardDetail.do")
	public String boardDetail(int unq, ModelMap model) throws Exception {
		
		// 조회수 증가
		boardService.updateBoardHits(unq);
		
		BoardVO result = boardService.selectBoardDetail(unq);
		model.addAttribute("result", result);
		
		return "board/boardDetail";
	}
	
	/**
	 * 수정 폼
	 */
	@RequestMapping("/boardModifyWrite.do")
	public String boardModifyForm(BoardVO vo, int unq, ModelMap model) throws Exception {
		
		BoardVO result = boardService.selectBoardDetail(unq);
		model.addAttribute("result", result);
		
		return "board/boardModifyWrite";
	}
	
	/**
	 * 수정 기능
	 */
	@ResponseBody
	@RequestMapping("/boardModifySave.do")
	public String updateBoard(BoardVO vo) throws Exception {
		
		System.out.println("받아온 데이터 정보: " + vo);
		
		StringBuilder message = new StringBuilder();
		message.append("fail");
		
		int count = boardService.selectBoardPass(vo);
		System.out.println("count: " + count);
		if (count == 1) {
			int result = boardService.updateBoard(vo);
			
			if (result == 1) {
				message.setLength(0);
				message.append("ok");
			} else if (result == -1) {
				message.append("passIncorrect");
				System.out.println("저장 실패");
			}
		}
		
		return message.toString();
	}
	
	/**
	 * 삭제 폼
	 */
	@RequestMapping("/passWrite.do")
	public String passWrite(int unq, ModelMap model) {
		
		model.addAttribute("unq", unq);
		return "board/passWrite";
	}
	
	/**
	 * 삭제 기능
	 */
	@ResponseBody
	@RequestMapping("/boardDelete.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		
		System.out.println("dd");
		
		StringBuilder message = new StringBuilder();
		message.append("fail");
		
		// 암호 일치 검사 (count = 1;(일치함) / count = 0;(일치하지 않음)
		int count = boardService.selectBoardPass(vo);
		System.out.println("count: " + count);
		if (count == 1) {
			int result = boardService.deleteBoard(vo);
			if (result == 1) {
				message.setLength(0);
				message.append("ok");
			}
		} else {
			message.setLength(0);
			message.append("passIncorrect");
		}
		
		System.out.println("message: " + message.toString());
		
		return message.toString();
	}
	
}
