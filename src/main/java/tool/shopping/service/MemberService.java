package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Member;
import tool.shopping.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    AppConfig appConfig = new AppConfig();

    //회원가입
    @Transactional
    public Long join(MemberDto memberDto){
        //DTO -> ENTITY로 변환
        Member member = appConfig.modelMapper().map(memberDto, Member.class);
        Member save = memberRepository.save(member);
        return save.getId();
    }

    @Transactional
    public Long update(String name,String email,MemberDto memberDto){
        //변경감지를 통한 회원정보수정
        List<Member> byName = memberRepository.findByName(memberDto.getName());
        Member member = appConfig.modelMapper().map(byName.get(0), Member.class);
        member.update(name,email,member);
        return member.getId();
    }
    
    
    //회원 탈퇴
    @Transactional
    public void delete(MemberDto memberdto){
        Member member = appConfig.modelMapper().map(memberdto, Member.class);
        memberRepository.delete(member);
    }

    //회원 이름으로 조회
    public MemberDto findByName(String name){
        //Repository에서 Entity조회
        List<Member> findmember = memberRepository.findByName(name);
        List<MemberDto> memberDtos = new ArrayList<>();

        //Entity -> DTO 변환
        for(Member member:findmember){
            memberDtos.add(appConfig.modelMapper().map(member,MemberDto.class));
        }
        return memberDtos.get(0);
    }

    //회원 아이디로 조회
    public MemberDto findById(Long id) throws Exception {
        Optional<Member> byId = memberRepository.findById(id);
        if(byId.isPresent()){
            return appConfig.modelMapper().map(byId,MemberDto.class);
        }else{
            throw new Exception();
        }
    }

    //모든 회원 조회
    public List<MemberDto> findall(){
        List<Member> members = memberRepository.findAll();
        List<MemberDto> result = members.stream()
                .map(MemberDto::new)
                .collect(toList());
        return result;
    }

}
