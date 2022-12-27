package tool.shopping.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Member;
import tool.shopping.repository.MemberRepository;
import tool.shopping.service.MemberService;

import java.util.List;

//시큐리티 설정에서 .loginProcessingUrl("/login");
//login 요청이 오면 UserDetailsService 타입으로 IOC되어있는 loadUserByUsername함수가 실행된다.
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    //시큐리티 session(내부 Authentication(내부 UserDetail))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<Member> byName = memberRepository.findByName(username);
        MemberDto memberDto = memberService.findByName(username);

        if(byName != null){
            return new PrincipalDetails(memberDto);
        }
        return null;
    }
}
