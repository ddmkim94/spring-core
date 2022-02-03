package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /**
     * OCP, DIP 위반!!! -> 인터페이스와 구현체 모두에게 의존함!
     * 다형성 만으로는 OCP 원칙을 지킬 수 없음 -> 객체를 생성하고 연관관계를 설정해주는 조립, 설정자가 필요함 -> 스프링 컨테이너
     */

    private final MemberRepository repository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        repository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return repository.findById(id);
    }
}
