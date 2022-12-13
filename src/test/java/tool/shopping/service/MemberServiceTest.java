package tool.shopping.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.entity.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class MemberServiceTest {

    @Autowired MemberService memberService;


    @Test
    public void jointest() {
        Member member = new Member("test2");
        Member join = memberService.join(member);
        assertThat(join.getName()).isEqualTo("test2");
    }

    @Test
    public void deletetest(){
        Member member = new Member("test1");
        memberService.delete(member);
        List<Member> test1 = memberService.findByName("test1");
        System.out.println("findmember = "+ test1);
    }

//    @Test
//    public

}