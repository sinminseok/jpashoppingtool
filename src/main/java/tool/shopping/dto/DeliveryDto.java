package tool.shopping.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.DeliveryStatus;

@Getter
@NoArgsConstructor
public class DeliveryDto {
    private Long id;
    private DeliveryStatus status;
    private String address;

    public DeliveryDto(DeliveryStatus status,String address){

        this.status = status;
        this.address = address;
    }

    public DeliveryDto(Delivery delivery){
        this.id = delivery.getId();
        this.status = delivery.getStatus();
        this.address = delivery.getAddress();
    }
}
