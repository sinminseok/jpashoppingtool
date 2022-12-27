package tool.shopping.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tool.shopping.dto.CartItemDto;
import tool.shopping.dto.ItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Item;
import tool.shopping.service.CartItemService;
import tool.shopping.service.ItemService;
import tool.shopping.service.MemberService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartItemController_Member {

    private final CartItemService cartItemService;
    private final MemberService memberService;
    private final ItemService itemService;

    //장바구니 조회 controller
    @GetMapping("/member/cartitem")
    public String category(Principal principal , Model model){
        MemberDto memberDto = memberService.findByName(principal.getName());
        List<CartItemDto> cartitem = cartItemService.findByMember(memberDto);
        model.addAttribute("cart_items",cartitem);
        return "member/cartitem/cartitemList";
    }

   // 상품 리스트에서 장바구니담기 controller
    @PostMapping("/member/cartitem/add/{itemId}")
    public String add(@PathVariable("itemId") Long itemId,Principal principal) throws Exception {

        //int count, String name, int price, Member member, Item item
        MemberDto memberDto = memberService.findByName(principal.getName());
        ItemDto itemDto = itemService.findByID(itemId);
        CartItemDto cartItemDto = new CartItemDto(memberDto,itemDto);
        cartItemService.save(cartItemDto);
        return "redirect:/";

    }

    @PostMapping("/member/cartitem/remove/{cartitem_id}")
    public String remove(@PathVariable("cartitem_id") Long cartitem_id){
        System.out.println("LOGG");
        cartItemService.delete(cartitem_id);
        return "redirect:/";
    }


}
