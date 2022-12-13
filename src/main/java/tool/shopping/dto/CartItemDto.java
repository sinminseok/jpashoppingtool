package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;

@Data
public class CartItemDto {

    private Long id;
    private int count;
    private String name;
    private int price;
    private Member member;

    public CartItemDto(Long id,int count,String name,int price,Member member){
        this.id =id;
        this.count =count;
        this.name = name;
        this.price = price;
        this.member = member;
    }

    public CartItemDto(CartItem cartItem){
        this.id =cartItem.getId();
        this.count =cartItem.getCount();
        this.name = cartItem.getName();
        this.price = cartItem.getPrice();
        this.member = cartItem.getMember();
    }


}
