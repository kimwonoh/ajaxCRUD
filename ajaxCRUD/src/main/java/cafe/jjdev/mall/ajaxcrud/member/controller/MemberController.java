package cafe.jjdev.mall.ajaxcrud.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.mall.ajaxcrud.member.Service.MemberService;
import cafe.jjdev.mall.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.mall.ajaxcrud.member.vo.Member;

@RestController
public class MemberController {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberService memberService;
	
	//리스트
	@GetMapping("/getMembers")
	public Map<String, Object> getMembers(Model model, @RequestParam(value="currentPage", defaultValue = "1") int currentPage){
		System.out.println("/getMembers 요청");
		Map<String, Object> map = memberService.selectMemberList(currentPage);
		System.out.println("MemberController.getMembers:" +map);

		return map;
	}
	//회원추가
	@PostMapping(value = "/addMember")
	public void addMember(Member member) {
		System.out.println("/addMember 요청");
		System.out.println("MemberController.addMember:"+member);
		memberMapper.insertMember(member);
	}
	//회원삭제
	@PostMapping(value = "/removeMember")
	public void removeMember(@RequestParam(value="ck[]") String[] ck) {
		System.out.println("/removeMember 요청");
		System.out.println("MemberController.removeMember:"+ck.length);
		for(String id : ck) {
		Member member = new Member();
		member.setId(id);
		memberMapper.deleteMember(member);
		}
	}
	//회원수정
	@PostMapping(value = "/modifyMember")
	public void modifyMember(Member member) {
		System.out.println("/modifyMember 요청");
		System.out.println("MemberController.modifyMember:"+member);
		memberMapper.updateMember(member);
	}
}
