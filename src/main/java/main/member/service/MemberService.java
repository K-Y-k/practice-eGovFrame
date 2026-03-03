package main.member.service;

import java.util.List;

import main.member.vo.MemberVO;

public interface MemberService {
	
	public String insertMember(MemberVO vo) throws Exception;
	public int selectMemberIdCheck(String userid) throws Exception;
	public List<?> selectPostList(String dong) throws Exception;
	public int selectMemberCount(MemberVO vo) throws Exception;
	
}
