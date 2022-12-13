package tool.shopping.dto;


import lombok.Data;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.DeliveryStatus;

@Data
public class DeliveryDto {
    private Long id;
    private DeliveryStatus status;
    private String address;

    public DeliveryDto(Long id,DeliveryStatus status,String address){
        this.id = id;
        this.status = status;
        this.address = address;
    }

    public DeliveryDto(Delivery delivery){
        this.id = delivery.getId();
        this.status = delivery.getStatus();
        this.address = delivery.getAddress();
    }
}
