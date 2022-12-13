package tool.shopping.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import tool.shopping.repository.MemberRepository;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberApiController {

    //자동주입
    private MemberRepository memberRepository;


}
