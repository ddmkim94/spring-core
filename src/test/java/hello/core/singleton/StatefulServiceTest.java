package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ctx.getBean(StatefulService.class);
        StatefulService statefulService2 = ctx.getBean(StatefulService.class);

        int price1 = statefulService1.order("동민", 10000);
        int price2 = statefulService2.order("은빈", 20000);

        System.out.println("price1 = " + price1); // 10000

        Assertions.assertThat(price1).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
