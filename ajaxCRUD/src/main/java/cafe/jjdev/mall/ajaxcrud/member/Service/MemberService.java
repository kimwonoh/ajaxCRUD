package cafe.jjdev.mall.ajaxcrud.member.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.mall.ajaxcrud.member.vo.Member;

@Service
@Transactional
public class MemberService {
		@Autowired
		private MemberMapper memberMapper;
		
		//페이징 작업
		public Map<String, Object> selectMemberList(int currentPage){
			Map<String, Object> map = new HashMap<String, Object>();
			final int ROW_PER_PAGE = 15;
			int firstRow = (currentPage-1)*ROW_PER_PAGE;
			map.put("rowPerPage", ROW_PER_PAGE);
			map.put("firstRow", firstRow);
			
			List<Member> list = memberMapper.selectMemberList(map);
			int memberConut = memberMapper.selectMemberCount();
			int lastPage = memberConut/ROW_PER_PAGE;
			if(lastPage%ROW_PER_PAGE != 0) {
				lastPage++;
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("list", list);
			resultMap.put("lastPage", lastPage);
			resultMap.put("currentPage", currentPage);
			resultMap.put("memberConut", memberConut);
			
			return resultMap;
		}
}
