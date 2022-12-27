package tool.shopping.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import tool.shopping.dto.ItemDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stock_quantity;

    @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
    private List<CartItem> cartItem = new ArrayList<CartItem>();

    @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public Item(String name,int price,int stock_quantity){
        this.name = name;
        this.price =price;
        this.stock_quantity = stock_quantity;
    }




}
