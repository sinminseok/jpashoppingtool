package tool.shopping.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tool.shopping.dto.MemberDto;
import tool.shopping.form.MemberForm;
import tool.shopping.service.MemberService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MemberController_Member {

    private final MemberService memberService;

    @GetMapping("member/mypage")
    public String mypage(Principal principal, Model model){
        System.out.println("principal.getName() = " + principal.getName());
        MemberDto memberDto = memberService.findByName(principal.getName());
        model.addAttribute("member",memberDto);
        return "member/mypage/mypage";
    }


    //회원정보 수정 폼
    @GetMapping("member/mypage/update")
    public String getform(Principal principal,Model model){
        MemberDto memberDto = memberService.findByName(principal.getName());

        MemberForm memberForm = new MemberForm();
        memberForm.setEmail(memberDto.getEmail());
        memberForm.setName(memberDto.getName());

        model.addAttribute("member",memberDto);
        model.addAttribute("form",memberForm);
        return "member/mypage/editform";
    }

    @PostMapping("member/mypage/update")
    public String update(Principal principal, Model model, @RequestParam("name")String name,@RequestParam("email") String email){
        MemberDto byName = memberService.findByName(principal.getName());
        memberService.update(name,email,byName);
        return "redirect:/";
    }
}
