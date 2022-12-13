package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tool.shopping.entity.Member;
import tool.shopping.repository.customrepository.MemberRepositoryCustom;

//@Repository
public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
}
