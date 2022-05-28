package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // @Autowired DataSource datasource;
    // private DataSource dataSource;
    // private EntityManager em; // 원래는 @PersistenceContext로 주입받음
    private final MemberRepository memberRepository;

    // @Autowired
    // public SpringConfig(DataSource dataSource) { this.dataSource = dataSource; }
    // @Autowired
    // public SpringConfig(EntityManager em) { this.em = em; }
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    // }

    // @Bean // TimeTraceAop.java 클래스에서 @Component를 사용해서 등록
    // public TimeTraceAop timeTraceAop() {
        // return new TimeTraceAop();
    // }

}
