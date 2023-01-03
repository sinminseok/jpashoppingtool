package tool.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Member;
import tool.shopping.entity.MemberRole;
import tool.shopping.form.MemberForm;
import tool.shopping.service.MemberService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


//강의에선 indexcontroller
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;

    @GetMapping(value = "/")
    public String home(Principal principal, Model model) {
        if (principal == null) {
            return "error/error";
        } else {
            MemberDto memberDto = memberService.findByName(principal.getName());
            if (memberDto.getRole() == MemberRole.ROLE_ADMIN) {
                model.addAttribute("member", memberDto);
                return "admin/index";
            } else {
                return "member/index";
            }

        }

    }

    @GetMapping(value = "/user/denied")
    public String denied() {
        return "account/denied";
    }


}
