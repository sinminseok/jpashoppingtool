package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.ItemDto;
import tool.shopping.entity.Item;
import tool.shopping.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    AppConfig appConfig = new AppConfig();


    //상품등록
    @Transactional
    public Long save(ItemDto itemDto){
        //컨트롤러 에서 받아오기까진 DTO지만 서비스에서 repository 로 넘어갈땐 Entity 로 변환
        Item convertitem = appConfig.modelMapper().map(itemDto, Item.class);
        Item saveitem = itemRepository.save(convertitem);
        return saveitem.getId();
    }

    @Transactional
    public ItemDto findByID(Long id) throws Exception{
        Optional<Item> byId = itemRepository.findById(id);
        System.out.println("TEST ="+byId.get().getId());

        if (byId.isPresent()) {
            return appConfig.modelMapper().map(byId.get(), ItemDto.class);
        } else {
            throw new Exception();
        }
    }

    //상품삭제
    @Transactional
    public void delete(ItemDto itemDto){
        Item map = appConfig.modelMapper().map(itemDto, Item.class);
        itemRepository.delete(map);

    }

    //모든 아이템 조회
    public List<ItemDto> findall(){
        List<Item> itemList = itemRepository.findAll();
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Item element: itemList) {
            itemDtoList.add(appConfig.modelMapper().map(element,ItemDto.class));
        }

        return itemDtoList;
    }

    //상품명으로 검색
    public List<ItemDto> findByName(String name){
        List<Item> byNameContaining = itemRepository.findByNameContaining(name);
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        for(Item element : byNameContaining){
            itemDtoList.add(appConfig.modelMapper().map(element, ItemDto.class));
        }

        return itemDtoList;
    }
}
