package tool.shopping.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import tool.shopping.entity.Member;
import tool.shopping.entity.MemberRole;
import tool.shopping.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    private String name;
    private String password;
    private String email;
    private MemberRole role;
    private List<Order> orders = new ArrayList<>();
    private List<CartItemDto> cartItemDtoList;



    public MemberDto(Long id,String name){
        this.id = id;
        this.name = name;
    }

    //회원가입 생성자
    public MemberDto(String name,String password,String email,MemberRole memberRole){
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = memberRole;
    }

    //회원정보 수정 생성자
    public MemberDto(Long id,String password,String email){
        this.id =id;
        this.password = password;
        this.email =email;
    }

    public MemberDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.password  = member.getPassword();
        this.role = member.getRole();
       // this.cartItemDtoList = member.getCartItems();
    }




}
