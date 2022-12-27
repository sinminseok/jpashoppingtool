package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tool.shopping.entity.Item;
import tool.shopping.entity.Member;
import tool.shopping.repository.customrepository.MemberRepositoryCustom;

import java.util.List;

//@Repository
public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {

    List<Member> findByNameContaining(String name);



}
