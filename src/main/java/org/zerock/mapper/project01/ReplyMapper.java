package org.zerock.mapper.project01;

import java.util.List;

import org.zerock.domain.project01.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> list(Integer boardId);

	public int insert(ReplyVO reply);

	public ReplyVO selectById(Integer id);

	public int update(ReplyVO newReply);

	public int delete(Integer id);

	public int deleteByBoardId(Integer boardId);

	public int deleteByMemberId(String id);
	
}
