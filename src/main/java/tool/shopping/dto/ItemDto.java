package tool.shopping.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Item;
import tool.shopping.entity.Member;
import tool.shopping.entity.OrderItem;
import tool.shopping.exception.NotEnoughStockException;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString(exclude = {"id", "name", "price", "stock_quantity"})
public class ItemDto {


    private Long id;
    private String name;
    private int price;
    private int stock_quantity;


    public ItemDto(String name, int price, int stock_quantity) {
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }

    public ItemDto(Long id, String name, int price, int stock_quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }

    public void addStock(int stock_quantity) {
        this.stock_quantity += stock_quantity;
    }

    public void removeStock(int stock_quantity) {
        int restStock = this.stock_quantity - stock_quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException(
                    "need more stock"
            );
        }
        this.stock_quantity = restStock;
    }


}
