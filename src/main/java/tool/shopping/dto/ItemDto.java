package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Item;
import tool.shopping.entity.Member;

import java.util.List;

@Data
public class ItemDto {


    private Long id;
    private String name;
    private int price;
    private int stock_quantity;

    public ItemDto(Long id,String name,int price,int stock_quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }

    public ItemDto(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.stock_quantity = item.getStock_quantity();
    }

}
