package tool.shopping.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;
import tool.shopping.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private LocalDateTime orderdate;

    private MemberDto member;

    private DeliveryDto delivery;

    private List<OrderItemDto> orderItems = new ArrayList<>();

    private OrderStatus status;

    public OrderDto(Long id, List<OrderItemDto> orderItemDtos, LocalDateTime orderdate, MemberDto member, DeliveryDto delivery, OrderStatus status) {
        this.id = id;
        this.orderdate = orderdate;
        this.member = member;
        this.orderItems = orderItems;
        this.delivery = delivery;
        this.status = status;
    }

    public static OrderDto createOrderDto(MemberDto member, DeliveryDto delivery, OrderItemDto... orderItemDtos) {
        OrderDto orderDto = new OrderDto();
        orderDto.setMember(member);
        orderDto.setDelivery(delivery);

        for (OrderItemDto orderItemDto : orderItemDtos) {
            orderDto.addOrderItemDto(orderItemDto);
        }


        orderDto.setStatus(OrderStatus.ORDER);
        orderDto.setOrderdate(LocalDateTime.now());
        return orderDto;

    }

    public void addOrderItemDto(OrderItemDto orderItemDto) {
        orderItems.add(orderItemDto);
        orderItemDto.setOrder(this);
    }

    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.FINISH) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불 가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);

    }


}
