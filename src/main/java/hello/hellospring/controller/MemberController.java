package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberservice;
    // @Autowired private MemberService memberservice; // 필드 주입 방식
    
    @Autowired // Spring 컨테이너에 있는 memberService를 자동(Auto) 주입시켜 줌.
    public MemberController(MemberService memberService) {
        this.memberservice = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // System.out.println("member = " + member.getName());

        memberservice.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
