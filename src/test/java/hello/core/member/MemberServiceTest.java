package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    /**
     * 각 테스가 실행되기 전에 실행되는 메서드
     * 테스트가 2개라면 2번 실행
     */
    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
    }

    @Test
    void join() throws Exception {
        //given
        Member member = new Member(1L, "member1", Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}