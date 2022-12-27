package tool.shopping.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.shopping.dto.MemberDto;
import tool.shopping.form.MemberForm;
import tool.shopping.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //로그인 페이지 이동
    @GetMapping("/login")
    public String loginForm(){
        return "account/loginForm";
    }


    //회원가입 폼
    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/account/joinForm";
    }

    //회원가입 POST
    @PostMapping("/join")
    public String join(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "account/joinForm";
        }
        String rawPassword = form.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        MemberDto memberDto = new MemberDto(form.getName(), encPassword, form.getEmail(), form.getRole());


        memberService.join(memberDto);
        return "redirect:/loginForm";
    }


    //모든회원 조회(ADMIN 계정만 사용가능)
    @GetMapping("/members")
    public String read_members(Model model){
        List<MemberDto> members = memberService.findall();
        model.addAttribute("members",members);
        return "/admin/members/memberList";

    }


}
