package tool.shopping.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
@EnableWebSecurity//스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨ㅇㅇ
//@EnableGlobalMethodSecurity(securedEnabled = true)//secured 어노테이션 활성화
public class SecurityConfig {

    private final UserDetailsService userDetailsService;


    //해당 메서드의 리턴되는 오브젝트를 IOC로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.logout() // 로그아웃 기능 작동함
                .logoutUrl("/logout") // 로그아웃 처리 URL, default: /logout, 원칙적으로 post 방식만 지원
                .logoutSuccessUrl("/login");
        http.authorizeRequests()
                .antMatchers("/").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        return http.build();
    }


}