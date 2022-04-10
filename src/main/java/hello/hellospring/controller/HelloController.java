package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")

    // 그냥 이 상태로 실행해서 root 뒤에 /hello-mvc를 하면 error가 발생한다.
    // 그 이유는 넘겨주는 parameter에 name이라는 것이 없기 때문이다.
    // 주소 맨 뒤에 ?name=spring을 통해 넘기면 spring이라는 name값이 넘어간다.
    public String helloMvc(@RequestParam("name") String name, Model model) {

    // 만약 이런 식으로 default 값이 true인 required를 false로 지정하면
    // 꼭 parameter를 지정하지 않아도 페이지로 이동한다.
    // public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {

        model.addAttribute("name", name);
        return "hello-template";
    }
}
