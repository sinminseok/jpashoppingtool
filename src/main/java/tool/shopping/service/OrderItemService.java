package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.OrderItemDto;
import tool.shopping.entity.OrderItem;
import tool.shopping.repository.OrderItemRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderItemService {

    private OrderItemRepository orderItemRepository;


    AppConfig appConfig =new AppConfig();

    //저장
    public Long save(OrderItemDto orderItemDto){
        OrderItem orderitem = appConfig.modelMapper().map(orderItemDto, OrderItem.class);
        OrderItem save = orderItemRepository.save(orderitem);
        return save.getId();

    }
}
