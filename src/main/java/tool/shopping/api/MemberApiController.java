package tool.shopping.api;


import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;
import tool.shopping.api.responseDto.MemberApiDto;
import tool.shopping.api.responseDto.UpdateMemberRequest;
import tool.shopping.api.responseDto.UpdateMemberResponse;
import tool.shopping.dto.MemberDto;
import tool.shopping.service.MemberService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    //회원가입 API
    @PostMapping("/api/members")
    public MemberApiDto saveMember(@RequestBody @Valid MemberDto memberDto) throws Exception {
        Long join = memberService.join(memberDto);
        return new MemberApiDto(join);
    }

    //회원정보 수정 API
    //Put은 보통 전체 업데이트를 할때 사용한다. 부분 업데이트를 하려면 PATCH OR POST를 사용하는게 REST스타일에 맞다.
    @PutMapping("/api/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) throws Exception {
        MemberDto byId = memberService.findById(id);
        memberService.update(request.getName(),"email",byId);
        return new UpdateMemberResponse(id,request.getName());
    }


}
