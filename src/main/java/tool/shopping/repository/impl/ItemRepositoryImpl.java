package tool.shopping.repository.impl;


import lombok.RequiredArgsConstructor;
import tool.shopping.entity.Item;
import tool.shopping.repository.customrepository.ItemRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.List;

//사용자 정의 구현 클래스 규칙을 준수해야 스프링 데이터 JPA가 인식후 스프링 빈으로 등록한다,.
//규칙 리포지토리 인터페이스 이름  + Imple

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Item> findByName(String name) {
        String query = "select i from Item i where i.name = :name";
        List<Item> resultList = em.createQuery(query)
                .setParameter("name", name)
                .getResultList();
        return resultList;
    }
}
