package tool.shopping.repository.impl;

import lombok.RequiredArgsConstructor;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.Member;
import tool.shopping.entity.Order;
import tool.shopping.repository.customrepository.DeliveryRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepositoryCustom {

    private final EntityManager em;


    //선택한 주문의 배송 정보
    @Override
    public List<Delivery> findByOrder(Order order) {
        String query= "select o.delivery from Order o";
        List resultList = em.createQuery(query).getResultList();
        return resultList;
    }
}
