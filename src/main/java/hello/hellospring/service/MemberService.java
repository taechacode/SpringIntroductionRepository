package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 만약 이런 방식으로 MemberServiceTest에서도 객체를 생성하면 2번 객체를 생성해버리게 된다.

    // 객체 생성을 2번하는 것을 방지하기 위해 DI를 사용한다.
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    회원 가입
    */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재하는 회원입니다.");
        // });

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember (Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다."); 
                });
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
