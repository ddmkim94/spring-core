package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        /*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        */

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ctx.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "은빈", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        System.out.println("== 가입을 요청한 회원 ==");
        System.out.println(member.getName() + ", " + member.getGrade());
        System.out.println("== 가입이 완료된 회원 ==");
        System.out.println(findMember.getName() + ", " + findMember.getGrade());
    }
}
