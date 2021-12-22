package org.zerock.domain.project01;

import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.Data;

@Data
public class ReplyVO {
	
	private Integer id;
	private Integer boardId;
	private String memberId;
	private String reply;
	private LocalDateTime inserted;
	private LocalDateTime updated;
	
	private String nickName;
	
	private Boolean own;
	
	public String getCustomInserted() {
		// 현재일시
		LocalDateTime now = LocalDateTime.now(ZoneId.of("+09:00")); // 서울시간 기준
		
		LocalDateTime beforeOneDayFRomNow = now.minusDays(1);	// 하루 뺀
		
		if (inserted.isBefore(beforeOneDayFRomNow)) {
			return inserted.toLocalDate().toString();	// 24시간 이후 날짜만
		} else {
			return inserted.toLocalTime().toString();	// 24시간 이전 시간만
		}
		
	}

}
