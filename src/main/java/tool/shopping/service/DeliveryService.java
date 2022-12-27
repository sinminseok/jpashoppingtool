package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.DeliveryDto;
import tool.shopping.dto.OrderDto;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.Order;
import tool.shopping.repository.DeliveryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    AppConfig appConfig = new AppConfig();

    //주문으로 배송지 등록 OrderService에서 배송지 등록후 해당 Delivery를 바로 사용하기 때문에 아이디가 아닌 Entity로 반환
    public Delivery registerDelivery(DeliveryDto deliveryDto){
        Delivery delivery = appConfig.modelMapper().map(deliveryDto, Delivery.class);
        deliveryRepository.save(delivery);
        return delivery;

    }

    //주문으로 배송 정보 찾기
    public List<DeliveryDto> findByOrder(Order order){
        List<Delivery> deliveries = deliveryRepository.findByOrder(order);
        List<DeliveryDto> deliveryDtos = new ArrayList<>();

        for(Delivery delivery : deliveries){
            deliveryDtos.add(appConfig.modelMapper().map(delivery,DeliveryDto.class));
        }
        return deliveryDtos;
    }
}
