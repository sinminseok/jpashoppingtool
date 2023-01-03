package tool.shopping.api;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.shopping.dto.OrderDto;
import tool.shopping.entity.Order;
import tool.shopping.service.OrderService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;
    
    @GetMapping("api/orders")
    public List<OrderDto> orders(){
        List<OrderDto> findall = orderService.findall();
        return findall;
    }

    @GetMapping("/api/v2/orders")
    public List<SimpleOrderDto> ordersv2(){
        List<OrderDto> findall = orderService.findall();
        List<SimpleOrderDto> collect = findall.stream().map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return collect;
    }



    @Data
    static class SimpleOrderDto{
        private Long orderId;
        private String name;

        public SimpleOrderDto(OrderDto order){
            orderId = order.getId();
            name = order.getMember().getName();
        }
    }
}
