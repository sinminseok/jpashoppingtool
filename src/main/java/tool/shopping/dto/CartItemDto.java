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

    public CartItemDto(MemberDto member,ItemDto item){
        this.member = member;
        this.item = item;
    }

}
