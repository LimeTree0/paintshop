package com.limecoding.paintshop.controller;

import com.limecoding.paintshop.domain.User;
import com.limecoding.paintshop.dto.JoinDto;
import com.limecoding.paintshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/join")
    public String getJoin(Model model) {
        model.addAttribute("user", new JoinDto());
        return "join";
    }

    @PostMapping("/join")
    public String postJoin(@ModelAttribute("user") JoinDto joinDto) {
        log.info("[HomeController] joinDto={}", joinDto);
        log.info("[HomeController] userService={}", userService);
        userService.registerUser(joinDto);
        return "redirect:/";
    }



}
