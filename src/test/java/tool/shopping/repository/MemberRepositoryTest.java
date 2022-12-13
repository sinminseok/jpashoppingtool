package tool.shopping.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.entity.Member;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
@Rollback(value = false)
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {


    @Autowired MemberRepository memberRepository;

    @Test
    public void testsave(){
      Member member = new Member("test1");
      Member savemember = memberRepository.save(member);
        System.out.println("savemember = " + savemember.getName());
    }
}