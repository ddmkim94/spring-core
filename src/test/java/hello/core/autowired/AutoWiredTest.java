package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestBean.class);
//        System.out.println(ctx.getBean("setNoBean1"));
//        System.out.println(ctx.getBean("setNoBean2"));
//        System.out.println(ctx.getBean("setNoBean3"));
    }


    static class TestBean {

        // 호출 X
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("setBean1 = " + member);
        }

        // null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setBean2 = " + member);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setBean3 = " + member);
        }
    }
}