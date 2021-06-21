package rw.co.aos.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/hello")
    public String getHelloPage(){
        return "hello";
    }

    @GetMapping("/international")
    public String getInternationalPage(){
        return "index";
    }

    
}
