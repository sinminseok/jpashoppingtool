package tool.shopping.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tool.shopping.dto.ItemDto;
import tool.shopping.form.ItemSearch;
import tool.shopping.service.ItemService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController_Member {


    private final ItemService itemService;

    @GetMapping(value = "member/items")
    public String list(String keyword, Model model){
        List<ItemDto> items= itemService.findall();
        List<ItemDto> searchs = itemService.findByName(keyword);

        model.addAttribute("items",items);
        model.addAttribute("searchs",searchs);
        return "member/items/itemList";
    }

    @GetMapping(value = "member/items/{id}/detail")
    public String detail(@PathVariable("id") Long itemId, Model model) throws Exception {
        ItemDto itemDto = itemService.findByID(itemId);
        model.addAttribute("item",itemDto);
        return "member/items/itemDetail";
    }


}
