package tool.shopping.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private String address;
}
