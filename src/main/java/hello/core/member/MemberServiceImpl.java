package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    /**
     * OCP, DIP 위반!!! -> 인터페이스와 구현체 모두에게 의존함!
     * 다형성 만으로는 OCP 원칙을 지킬 수 없음 -> 객체를 생성하고 연관관계를 설정해주는 조립, 설정자가 필요함 -> 스프링 컨테이너
     */

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
