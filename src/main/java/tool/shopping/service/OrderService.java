package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.entity.Order;
import tool.shopping.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    //주문생성
    public Long order(Order order){
        Order save = orderRepository.save(order);
        return save.getId();
    }


    //주문 취소
    public void cancel_order(Order order){
        orderRepository.delete(order);
        return;
    }

    //모든 주문 조회
    public List<Order> find_all_order(){
        return orderRepository.findAll();
    }

    public Optional<Order> find_order_id(Long id){
        return orderRepository.findById(id);
    }


}
