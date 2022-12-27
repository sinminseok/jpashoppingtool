package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.CartItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;
import tool.shopping.repository.CartItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    AppConfig appConfig = new AppConfig();

    //장바구니 아이템 추가
    @Transactional
    public Long save(CartItemDto cartItemDto){
        CartItem cartItem = appConfig.modelMapper().map(cartItemDto, CartItem.class);
        CartItem save = cartItemRepository.save(cartItem);
        return save.getId();
    }

    //장바구니 아이템 삭제
    @Transactional
    public void delete(Long id){
        Optional<CartItem> byId = cartItemRepository.findById(id);
        CartItem cartItem = appConfig.modelMapper().map(byId.get(), CartItem.class);
        cartItemRepository.delete(cartItem);
    }


    //장바구니 조회
    @Transactional
    public List<CartItemDto> findByMember(MemberDto memberDto) {
        Member member = appConfig.modelMapper().map(memberDto, Member.class);
        List<CartItem> allByMember = cartItemRepository.findAllByMember(member);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem element : allByMember) {
            cartItemDtos.add(appConfig.modelMapper().map(element, CartItemDto.class));
        }
        return cartItemDtos;
    }



}
