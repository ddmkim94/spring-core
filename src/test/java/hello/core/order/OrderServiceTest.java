package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
        orderService = config.orderService();
    }
    
    @Test
    public void orders() throws Exception {
        //given
        Member member1 = new Member(1L, "동민", Grade.VIP);
        Member member2 = new Member(2L, "은빈", Grade.BASIC);

        // when
        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member1.getId(), "커피", 4000);
        Order order2 = orderService.createOrder(member2.getId(), "밀크티", 6000);

        // then
        assertThat(3000).isEqualTo(order1.calculatePrice());
        assertThat(6000).isEqualTo(order2.calculatePrice());
    }
}