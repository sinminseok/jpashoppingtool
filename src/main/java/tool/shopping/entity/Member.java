package tool.shopping.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    //Member 의 name 은 고유값이므로 중복X
    private String name;

    private String password;

    private String email;

    //Member와Order는 1:N관계
    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Order> orders = new ArrayList<Order>();

    //고아 객체 자동 삭제를 활성화(카테코리아이템은 멤버가 가지고 있는 개인 참조이기 때문)
    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    @Enumerated(EnumType.STRING)
    private MemberRole role;


    //이름만 넣은 생성자
    public Member(String name) {
        this.name = name;
    }

    //이름 이메일 넣은 생성자
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //회원정보 수정시 사용되는 method
    public void update(String name,String email,Member member) {
        this.id = member.id;
        this.name = name;
        this.email = email;
        this.password = member.password;

    }


}
