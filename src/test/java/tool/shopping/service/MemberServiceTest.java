package tool.shopping.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Member;
import tool.shopping.entity.MemberRole;
import tool.shopping.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AppConfig appConfig;



    @Test
    public void 회원가입(){

        MemberDto memberDto = new MemberDto("test1212","test1212","minseok12@naver.com",MemberRole.ROLE_ADMIN);
        memberService.join(memberDto);
    }

    @Test
    public void 회원탈퇴(){

    }

    @Test
    public void 모든회원조회(){
        Long id = Long.valueOf(1);
        MemberDto memberDto = new MemberDto(id,"minseok");
        memberService.join(memberDto);
        Long id2 = Long.valueOf(2);
        MemberDto memberDto2 = new MemberDto(id2,"minseok2");
        memberService.join(memberDto2);
        List<MemberDto> findall = memberService.findall();
        Assertions.assertThat(findall.size()).isEqualTo(2);
    }
    
    @Test
    public void 회원정보수정() throws Exception {
        MemberDto findMember = memberService.findByName("ggg");
        System.out.println("find = " + findMember.getName());
        memberService.update("rrr","update@naver.com",findMember);
    }





}