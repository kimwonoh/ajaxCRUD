package cafe.jjdev.mall.ajaxcrud.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	//멤버목록
	public List<Member> selectMemberList(Map<String, Object> map);
	//회원추가
	public int insertMember(Member member);
	//회원삭제
	public int deleteMember(Member member);
	//회원수정
	public int updateMember(Member member);
	//멤버목록 페이징 카운터
	public int selectMemberCount();
}
