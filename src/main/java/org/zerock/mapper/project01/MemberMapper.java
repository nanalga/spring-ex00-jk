package org.zerock.mapper.project01;

import java.util.List;

import org.zerock.domain.project01.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO member);
	
	public MemberVO select(String id);
	
	public int update(MemberVO member);
	
	public int delete(String id);
	
	public List<MemberVO> list();	// 회원정보 리스트

}
