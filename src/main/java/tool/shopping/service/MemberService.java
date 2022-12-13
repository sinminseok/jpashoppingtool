package tool.shopping.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.entity.Member;
import tool.shopping.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Member join(Member member){
     //   validateDuplicateMember(member);
        memberRepository.save(member);
        return member;
    }
    
    
    //회원 탈퇴
    @Transactional
    public void delete(Member member){
        memberRepository.delete(member);
        return;
    }

    public List<Member> findByName(String name){
        List<Member> findmember = memberRepository.findByName(name);
        return findmember;
    }

    //회원 조회
    public List<Member> findall(){
        List<Member> members = memberRepository.findAll();
        return members;
    }
    
    //아이디로 회원 조회
    public Optional<Member> findById(Long id){
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    //
    private void validateDuplicateMember(Member member){
        Optional<Member> findMember = memberRepository.findById(member.getId());
        System.out.println("findMember = " + findMember);
        return;
    }


}
