package tool.shopping.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tool.shopping.dto.ItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.dto.OrderDto;
import tool.shopping.service.ItemService;
import tool.shopping.service.MemberService;
import tool.shopping.service.OrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping(value = "/order")
    public String createForm(Model model){
        List<MemberDto> members = memberService.findall();
        List<ItemDto> items = itemService.findall();

        model.addAttribute("members",members);
        model.addAttribute("items",items);

        return "admin/order/orderForm";
    }

    @PostMapping(value = "/order")
    public String order(@RequestParam("memberId") Long memberId,@RequestParam("itemId")Long itemId,@RequestParam("count")int count,@RequestParam("address")String address) throws Exception {
        orderService.order(memberId,itemId,count,address);
        return "redirect:/";

    }

    @GetMapping(value = "/orders")
    public String orderList(Model model){
        List<OrderDto> findall = orderService.findall();
        model.addAttribute("orders",findall);
        return "admin/order/orderList";
    }

    @GetMapping(value = "/order/{id}/detail")
    public String detail(@PathVariable("id") Long id,Model model) throws Exception {
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order",orderDto);
        return "admin/order/orderDetail";
    }

    @GetMapping(value = "/order/{id}/cancel")
    public String cancel(@PathVariable("id") Long id) throws Exception {
        orderService.status_change(id);
        return "redirect:/";
    }

    @GetMapping(value = "/order/{id}/delete")
    public String delete(@PathVariable("id") Long id) throws Exception{
        orderService.delete(id);
        return "redirect:/";
    }
}
