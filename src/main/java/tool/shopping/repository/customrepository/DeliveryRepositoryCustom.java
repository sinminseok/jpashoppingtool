package tool.shopping.repository.customrepository;


import lombok.RequiredArgsConstructor;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.Member;
import tool.shopping.entity.Order;

import java.util.List;


public interface DeliveryRepositoryCustom {

    //Delivery findby Member
    List<Delivery> findByMember(Order order);


}
