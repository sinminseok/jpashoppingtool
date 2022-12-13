package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    private LocalDateTime orderdate;

    private Member member;

    private Delivery delivery;

    private OrderStatus status;

    public OrderDto(Long id,LocalDateTime orderdate,Member member,Delivery delivery,OrderStatus status){

        this.id = id;
        this.orderdate = orderdate;
        this.member = member;
        this.delivery = delivery;
        this.status = status;
    }

    public OrderDto(Order order){

        this.id = order.getId();
        this.orderdate = order.getOrderdate();
        this.member = order.getMember();
        this.delivery = order.getDelivery();
        this.status = order.getStatus();
    }


}
