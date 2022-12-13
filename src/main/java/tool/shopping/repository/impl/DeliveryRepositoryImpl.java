package tool.shopping.repository.impl;

import lombok.RequiredArgsConstructor;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.Member;
import tool.shopping.entity.Order;
import tool.shopping.repository.customrepository.DeliveryRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Delivery> findByMember(Order order) {
        Long id = order.getId();
        String query = "select from Delivery d where d.order = :id";
        List resultList = em.createQuery(query).
                setParameter("id", id).getResultList();
        return resultList;
    }
}
