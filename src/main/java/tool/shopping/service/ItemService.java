package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.entity.Item;
import tool.shopping.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    //모든 아이템 조회
    public List<Item> findall(){
        return itemRepository.findAll();
    }

    public List<Item> findByName(String name){
        List<Item> result = itemRepository.findByName(name);
        return result;

    }
}
