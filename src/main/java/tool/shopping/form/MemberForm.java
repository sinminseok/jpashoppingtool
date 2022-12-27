package tool.shopping.form;


import lombok.Getter;
import lombok.Setter;
import tool.shopping.entity.MemberRole;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;

    private String password;

    private String email;

    private MemberRole role;


}
