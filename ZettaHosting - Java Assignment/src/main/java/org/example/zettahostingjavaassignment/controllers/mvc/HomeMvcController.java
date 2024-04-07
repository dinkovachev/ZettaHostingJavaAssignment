package org.example.zettahostingjavaassignment.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeMvcController {


    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "index";
    }

    @GetMapping
    public String redirectToHome() {
        return "redirect:/home";
    }
}
