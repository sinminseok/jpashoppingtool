package tool.shopping.config.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Member;

import java.util.ArrayList;
import java.util.Collection;
//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료과 되면 시큐리티 session을 만들어줍니다.

@Slf4j
public class PrincipalDetails implements UserDetails {

    private MemberDto memberDto;

    public PrincipalDetails(MemberDto memberDto){
        this.memberDto = memberDto;
    }

    //해당 User의 권한을 return하는 곳!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect=new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return String.valueOf(memberDto.getRole());
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        return memberDto.getPassword();
    }

    @Override
    public String getUsername() {
        return memberDto.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //1년동안 회원이 로그인을 안하면 휴면 계정으로 하기로함.이럴때 사용

        return true;
    }
}
