package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("컴포넌트 스캔과 @Autowired를 통한 빈 생성 및 주입 테스트")
    void beanTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ctx.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
