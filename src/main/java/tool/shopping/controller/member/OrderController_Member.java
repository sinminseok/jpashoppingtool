package tool.shopping.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tool.shopping.dto.ItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.dto.OrderDto;
import tool.shopping.dto.OrderItemDto;
import tool.shopping.service.ItemService;
import tool.shopping.service.MemberService;
import tool.shopping.service.OrderService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController_Member {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    //주문내역조회
    @GetMapping(value = "member/order")
    public String list(Model model) {
        List<OrderDto> findall = orderService.findall();
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        model.addAttribute("orders", findall);
        return "member/order/orderList";
    }

    //주문폼
    @GetMapping(value = "member/order/{itemId}")
    public String createForm(@PathVariable("itemId") Long itemId, Model model) throws Exception {
        ItemDto itemDto = itemService.findByID(itemId);
        model.addAttribute("item", itemDto);
        return "member/order/orderForm";
    }

    //주문 컨트롤러
    @PostMapping(value = "member/order/{id}")
    public String order(Principal principal, @PathVariable("id") Long itemId, @RequestParam("count") int count, @RequestParam("address") String address) throws Exception {

        MemberDto memberDto = memberService.findByName(principal.getName());
        orderService.order(memberDto.getId(), itemId, count, address);
        return "redirect:/";

    }
}
