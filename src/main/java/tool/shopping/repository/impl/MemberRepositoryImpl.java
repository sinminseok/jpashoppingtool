package tool.shopping.repository.impl;

import lombok.RequiredArgsConstructor;
import tool.shopping.entity.Member;
import tool.shopping.repository.customrepository.MemberRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Member> findByName(String name) {
        String query = "select m from Member m where m.name = :name";

        List resultList = em.createQuery(query)
                .setParameter("name", name)
                .getResultList();
        return resultList;
    }

}
