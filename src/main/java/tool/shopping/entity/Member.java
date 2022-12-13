package tool.shopping.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"id","name","password","email"})
@NoArgsConstructor
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String password;

    private String email;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    @OneToMany(mappedBy = "member")
    private List<CartItem> cartItems = new ArrayList<CartItem>();


    //이름만 넣은 생성자
    public Member(String name){
        this.name = name;
    }
    //이름 이메일 넣은 생성자
    public Member(String name,String email){
        this.name = name;
        this.email = email;

    }




}
