package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.*;
import tool.shopping.entity.*;
import tool.shopping.repository.ItemRepository;
import tool.shopping.repository.MemberRepository;
import tool.shopping.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class OrderService {


    //OrderService는 연관관계가 많이 연결되어있음
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final DeliveryService deliveryService;

    AppConfig appConfig = new AppConfig();

    //주문등록
    @Transactional
    public void order(Long memberId,Long itemId,int count,String address) throws Exception {
        // 엔티티 조회
        Optional<Member> member =  memberRepository.findById(memberId);
        Optional<Item> item = itemRepository.findById(itemId);

        ItemDto itemDto = new ItemDto();
        MemberDto memberDto = new MemberDto();


        //Optional Check
        if (member.isPresent()) {
             memberDto = appConfig.modelMapper().map(member.get(), MemberDto.class);
        } else {
            throw new Exception();
        }

        if (item.isPresent()) {
             itemDto = appConfig.modelMapper().map(item.get(), ItemDto.class);
        } else {
            throw new Exception();
        }

        //배송정보 생성
        DeliveryDto deliveryDto = new DeliveryDto(DeliveryStatus.PREPARE,address);
        Delivery delivery = deliveryService.registerDelivery(deliveryDto);
        DeliveryDto returndto = appConfig.modelMapper().map(delivery, DeliveryDto.class);


        //주문상품 생성
        OrderItemDto orderItemDto = OrderItemDto.createOrderItemDto(itemDto,itemDto.getPrice()*count,count);
        OrderDto orderDto = OrderDto.createOrderDto(memberDto,returndto,orderItemDto);


        Order map = appConfig.modelMapper().map(orderDto, Order.class);
       orderRepository.save(map);

    }


    @Transactional
    public List<OrderDto> findall(){
        List<Order> orderall = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();

        for(Order element:orderall){
            OrderDto orderdto = appConfig.modelMapper().map(element, OrderDto.class);
            orderDtos.add(orderdto);
        }

        return orderDtos;
    }

    @Transactional
    public OrderDto findById(Long id) throws Exception {
        Optional<Order> byId = orderRepository.findById(id);
        if(byId.isPresent()){
            return appConfig.modelMapper().map(byId.get(), OrderDto.class);
        }else{
            throw new Exception();
        }
    }

    @Transactional
    public void status_change(Long id) throws Exception {
        OrderDto orderdto = findById(id);
        orderdto.setStatus(OrderStatus.CANCEL);
        Order order = appConfig.modelMapper().map(orderdto, Order.class);
        orderRepository.save(order);

        // orderRepository.delete();

    }

    @Transactional
    public void delete(Long id) throws Exception{
        OrderDto orderdto = findById(id);
        Order map = appConfig.modelMapper().map(orderdto, Order.class);
        orderRepository.delete(map);

    }



}
