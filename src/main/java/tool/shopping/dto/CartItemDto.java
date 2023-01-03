package tool.shopping.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Item;
import tool.shopping.entity.Member;

@Getter
@NoArgsConstructor
public class CartItemDto {

    private Long id;
    private MemberDto member;
    private ItemDto item;
    private int count;
    private Boolean order_select;

    public CartItemDto(MemberDto member,ItemDto item,int count){
        this.member = member;
        this.item = item;
        this.count = count;
        this.order_select = true;
    }

}
