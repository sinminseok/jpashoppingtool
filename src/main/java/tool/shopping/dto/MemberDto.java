package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;

import java.util.List;

@Data
public class MemberDto {

    private Long id;
    private String name;
    private String email;
    private List<CartItem> cartItemDtoList;

    public MemberDto(Long id,String username,String teamName){
        this.id = id;
        this.name = name;
        this.email = email;
        this.cartItemDtoList = cartItemDtoList;
    }

    public MemberDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.cartItemDtoList = member.getCartItems();
    }
}
