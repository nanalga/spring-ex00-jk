package org.zerock.controller.p07controller_ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.p05controller.bean.Bean10;
import org.zerock.controller.p05controller.bean.Bean12;
import org.zerock.domain.project01.BoardVO;
import org.zerock.domain.project01.MemberVO;
import org.zerock.mapper.project01.BoardMapper;
import org.zerock.mapper.project01.MemberMapper;

import lombok.Setter;

@RequestMapping("/cont16")
@Controller
public class Controller16 {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@RequestMapping("/met01")
	@ResponseBody
	public String method01() {
		
		return "hello this is data";
	}
	@RequestMapping("/met02")
	@ResponseBody
	public String method02() {
		Bean10 b = new Bean10();
		b.setContactName("donald");
		b.setCustomerName("trump");
		
		// "JavaScript Object Notation" : JSON
		
		return "{ \"contactName\" : \"donald\", \"customerName\" : \"trump\" }";
	}
	
	@RequestMapping("/met03")
	@ResponseBody
	public Bean10 method03() {
		Bean10 b = new Bean10();
		b.setContactName("seoul");
		b.setCustomerName("jeju");
		
		return b;
	}
	
	@RequestMapping("/met04")
	@ResponseBody
	public Bean12 method04() {
		Bean12 b = new Bean12();
		b.setId(30);
		b.setLname("donald");
		b.setFname("trump");
		
		return b;
	}
	
	@RequestMapping("/met05")
	@ResponseBody
	public MemberVO method05() {
		MemberVO member = memberMapper.select("myid9");
		
		return member;
	}
	
	@RequestMapping("/met06")
	@ResponseBody
	public BoardVO method06() {
		BoardVO board = boardMapper.read(794);
		
		System.out.println(board);
		
		return board;
	}
	
	@RequestMapping("/met07")
	@ResponseBody
	public List<BoardVO> method07(){
		List<BoardVO> list = boardMapper.getListPage(0, 3);
		
		return list;
	}
	
	@RequestMapping("/met08")
	@ResponseBody
	public List<MemberVO> method08(){
		List<MemberVO> list = memberMapper.getListPage(0, 3);
		
		return list;
	}
	
}
