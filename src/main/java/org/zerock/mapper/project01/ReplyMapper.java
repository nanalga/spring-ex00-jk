package org.zerock.mapper.project01;

import java.util.List;

import org.zerock.domain.project01.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> list(Integer boardId);

	public int insert(ReplyVO reply);
	
}
