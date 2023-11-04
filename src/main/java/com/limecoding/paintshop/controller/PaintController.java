package com.limecoding.paintshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paint")
public class PaintController {
    @GetMapping
    public String paintMain() {
        return "paintMain";
    }
}
