package org.zerock.domain.project01;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String password;
	private String email;
	private String address;
	private String nickName;
	private LocalDateTime inserted;
	private Integer numberOfBoard;

}
