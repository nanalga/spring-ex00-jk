package org.zerock.mapper.project01;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.project01.BoardVO;

public interface BoardMapper {
	
	// 모든 게시물 조회
	public List<BoardVO> getList();
	
	// 새 케시물 입력 & get gernerated key
	public int insert(BoardVO board);
	
	// id(pk)로 하나의 게시물 조회
	public BoardVO read(Integer id);
	
	// id(pk)로 하나의 게시물 삭제
	public int delete(Integer id);
	
	// 하나의 게시물 수정
	public int update(BoardVO board);

	public List<BoardVO> getListPage(@Param("from") Integer page, @Param("items") Integer numberPerPage);

	public Integer getCountRows();
	
	
	
}
