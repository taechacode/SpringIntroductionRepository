package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberservice;
    // @Autowired private MemberService memberservice; // 필드 주입 방식
    
    @Autowired // Spring 컨테이너에 있는 memberService를 자동(Auto) 주입시켜 줌.
    public MemberController(MemberService memberService) {
        this.memberservice = memberService;
    }

}
