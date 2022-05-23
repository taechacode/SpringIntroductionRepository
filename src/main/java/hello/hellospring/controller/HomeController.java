package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 기본 localhost를 호출할 때 기본 맵핑된 HomeController가 있으므로 호출
    // (없으면 static의 index.html 호출)
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
