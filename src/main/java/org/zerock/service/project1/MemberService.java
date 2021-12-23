package org.zerock.service.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.project01.MemberVO;
import org.zerock.domain.project01.PageInfoVO;
import org.zerock.mapper.project01.BoardMapper;
import org.zerock.mapper.project01.MemberMapper;
import org.zerock.mapper.project01.ReplyMapper;

import lombok.Setter;

@Service
public class MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replymapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	public MemberVO read(String id) {
		return mapper.select(id);
	}
	
	public boolean register(MemberVO member) {
		try {
			return mapper.insert(member) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean modify(MemberVO member) {
		return mapper.update(member) == 1;
	}
	
	@Transactional
	public boolean remove(String id) {
		// 1. 멤버가 작성한 댓글 지우기
		replymapper.deleteByMemberId(id);
		
		// 2. 멤버가 작성한 게시물 지우기
		// 2.1 멤버가 작성한 게시물 목록 얻고
		Integer[] boardIds = boardMapper.selectByMemberId(id);
		
		// 2.2 게시물 삭제
		if(boardIds != null) {
			for(Integer boardId : boardIds) {
				boardService.remove(boardId);
			}
		}
		
		// 3. 멤버 지우기
		boardMapper.deleteByMemberId(id);
		
		return mapper.delete(id) == 1;
	}
	
	public List<MemberVO> getList(){
		return mapper.list();
	}

	public List<MemberVO> getListPage(Integer page, Integer numberPerPage) {
		// sql에서 사용할 record 시작 번호 (0-index)
		Integer from = (page -1) * numberPerPage;
		
		return mapper.getListPage(from, numberPerPage);
	}

	public PageInfoVO getPageInfo(Integer page, Integer numberPerPage) {
		// 총 레코드 수
		Integer countRows = mapper.getCountRows();
		
		// 마지막 페이지 번호
		Integer lastPage = (countRows -1) /numberPerPage + 1;
		
		// 페이지 네이션 가장 왼쪽 번호
		Integer leftPageNumber = page - 5;
		leftPageNumber = Math.max(1, leftPageNumber);	// page 1과 leftPageNumber중 큰 것
		// 페이지 네이션 가장 오른쪽 번호
		Integer rightPageNumber = leftPageNumber + 9;
		rightPageNumber = Math.min(rightPageNumber, lastPage);	// rightPageNumber와 lastPage 중 작은것
		
		// 다음 페이지 버튼 존재 유무
		Boolean hasNextButton = page != lastPage;	// (현재 page가 마지막 페이지와 안같으면) 다음페이지 버튼 존재
		// 이전 페이지 버튼 존재 유무
		Boolean hasPrevButton = page != 1; // (현재 page가 1 페이지와 안같으면) 다음페이지 버튼 존재
		
		// 가장 마지막 페이지를 넘어가지 않도록
		//rightPageNumber = rightPageNumber > lastPage ? lastPage : rightPageNumber;
		
		PageInfoVO pageInfo = new PageInfoVO();	// page정보를 가지고 있는 PageInfoVO 생성
		
		pageInfo.setLastPage(lastPage);		// 마지막 페이지
		pageInfo.setCountRows(countRows);	// 총개수
		pageInfo.setCurrentPage(page);		// 현재 페이지
		pageInfo.setLeftPageNumber(leftPageNumber); // 가장 왼쪽 페이지 번호
		pageInfo.setRightPageNumber(rightPageNumber);	// 가장 오른쪽 페이지 번호
		pageInfo.setHasPrevButton(hasPrevButton);	// 이젠 페이지
		pageInfo.setHasNextButton(hasNextButton);	// 다음 페이지
		
		return pageInfo;
	}

	public boolean hasId(String id) {
		MemberVO member = mapper.select(id);
				
		return member != null;	// null : 중복id 없다/false
	}

	public boolean hasNickName(String nickName) {
		MemberVO member = mapper.selectNickName(nickName);
		
		return member != null;
	}
	
}
