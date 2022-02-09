package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // 구체 타입으로 조회한 이유? -> 구현체 클래스 안의 getMemberRepository() 호출을 위해!!
        MemberServiceImpl memberService = ctx.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ctx.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ctx.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService = " + memberService.getMemberRepository());
        System.out.println("orderService = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = ctx.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass());
    }
}
