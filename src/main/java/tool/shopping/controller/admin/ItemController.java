package tool.shopping.controller.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tool.shopping.dto.ItemDto;
import tool.shopping.entity.Item;
import tool.shopping.form.ItemForm;
import tool.shopping.form.ItemSearch;
import tool.shopping.service.ItemService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    //새상품 등록 페이지
    @GetMapping(value = "/items/new")
    public String createForm(Model model){
        model.addAttribute("form",new ItemForm());
        return "admin/items/createdItemForm";
    }

    //새상품 등록 POST controller
    @PostMapping(value = "/items/new")
    public String create(ItemForm form){
        ItemDto item = new ItemDto(form.getName(),form.getPrice(),form.getStock_quantity());
        itemService.save(item);
        return "redirect:";
    }

    //모든 상품 조회
    @GetMapping(value = "/items")
    public String list(String keyword, Model model){
        System.out.println("keyword = " +keyword);
        List<ItemDto> items= itemService.findall();
        List<ItemDto> searchs = itemService.findByName(keyword);

        model.addAttribute("items",items);
        model.addAttribute("searchs",searchs);
        return "admin/items/itemList";
    }

    //상품 수정폼
    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId,Model model) throws Exception {
        ItemDto itemdto = itemService.findByID(itemId);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(itemdto.getId());
        itemForm.setName(itemdto.getName());
        itemForm.setPrice(itemdto.getPrice());
        itemForm.setStock_quantity(itemdto.getStock_quantity());

        model.addAttribute("form",itemForm);
        return "admin/items/updateItemForm";
    }

    @PostMapping(value = "items/{itemId}/edit")
    public String updateItem(@PathVariable("itemId")Long id, @ModelAttribute("form") ItemForm form){
        ItemDto itemDto = new ItemDto(id, form.getName(),form.getPrice(),form.getStock_quantity());
        itemService.save(itemDto);
        return "redirect:";
    }
}
