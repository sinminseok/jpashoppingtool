package tool.shopping.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tool.shopping.entity.Order;
import tool.shopping.entity.OrderItem;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private int count;
    private int price;
    private OrderDto order;
    private ItemDto item;

    OrderItemDto(Long id,int count,int price,OrderDto orderDto,ItemDto itemDto){
        this.order = orderDto;
        this.item = itemDto;
        this.id = id;
        this.count = count;
        this.price = price;
    }

    public static OrderItemDto createOrderItemDto(ItemDto itemDto,int price,int count){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setItem(itemDto);
        orderItemDto.setCount(count);
        orderItemDto.setPrice(price);
        itemDto.removeStock(count);
        return orderItemDto;
    }

    public void cancel(){
        getItem().addStock(count);
    }


}
