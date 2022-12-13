package tool.shopping.repository.customrepository;

import tool.shopping.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> findByName(String name);
}
