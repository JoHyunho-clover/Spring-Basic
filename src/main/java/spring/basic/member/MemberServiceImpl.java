package spring.basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //DIP 위반
    private final MemberRepository memberRepository; //DIP원칙 지키면서 DI적용

    @Autowired //안붙여도 되긴해 왜냐하면 생성자가 하나라서
    public MemberServiceImpl(MemberRepository memberRepository) { //DI 적용하면서 AppConfig를 이용함으로써 OCP원칙을 지킨다 - 이것은 생성자 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
