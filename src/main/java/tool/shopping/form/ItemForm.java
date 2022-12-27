package tool.shopping.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ItemForm {

    Long id;

    @NotEmpty
    private String name;
    private int price;
    private int stock_quantity;

}
