package org.zerock.mapper.project01;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.project01.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO member);
	
	public MemberVO select(String id);
	
	public int update(MemberVO member);
	
	public int delete(String id);
	
	public List<MemberVO> list();	// 회원정보 리스트

	public List<MemberVO> getListPage(@Param("from") Integer from, @Param("items") Integer numberPerPage); // page 처리

	public Integer getCountRows();

	public MemberVO selectNickName(String nickName);

}
