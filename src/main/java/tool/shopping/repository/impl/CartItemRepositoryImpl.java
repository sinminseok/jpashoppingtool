package tool.shopping.repository.impl;

import lombok.RequiredArgsConstructor;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;
import tool.shopping.repository.CartItemRepository;
import tool.shopping.repository.customrepository.CartItemRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class CartItemRepositoryImpl implements CartItemRepositoryCustom {

    private final EntityManager em;


    @Override
    public List<CartItem> findAllByMember(Member member) {
        String query  = "select ci from CartItem ci where ci.member.id = :memberid";
        List resultList = em.createQuery(query).setParameter("memberid",member.getId()) .getResultList();
        return resultList;
    }
}
