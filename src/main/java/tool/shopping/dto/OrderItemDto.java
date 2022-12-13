package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.Order;
import tool.shopping.entity.OrderItem;

@Data
public class OrderItemDto {

    private Long id;
    private int count;
    private int price;

    OrderItemDto(Long id,int count,int price){
        this.id = id;
        this.count = count;
        this.price = price;
    }

    OrderItemDto(OrderItem orderItem){
        this.id= orderItem.getId();
        this.count = orderItem.getCount();
        this.price = orderItem.getPrice();
    }
}
