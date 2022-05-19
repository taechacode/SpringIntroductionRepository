package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")

    // HTTP의 Header와 Body 중 Body에 return 값을 직접 넣어주겠다는 의미
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {

        // parameter로 spring을 넘겨줄 경우
        // 결과 화면을 페이지 소스보기 해보면 HTML 태그는 사라지고 "hello spring" 밖에 없다.
        return "hello " + name;
    }
    
    // 'viewResolver' 대신에 'HttpMessageConverter'가 동작
    // 객체는 기본적으로 JSON 방식으로 반환됨 (HttpMessageConverter에서 JsonConverter 동작)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
