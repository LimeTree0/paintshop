package com.limecoding.paintshop.controller;

import com.limecoding.paintshop.dto.PaintRequestDto;
import com.limecoding.paintshop.dto.PaintResponseDto;
import com.limecoding.paintshop.service.PaintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/paint")
public class PaintController {

    // 서비스 객체
    private final PaintService paintService;

    // 그림 메인 페이지
    @GetMapping
    public String paintMain(Model model) {
        List<PaintResponseDto> paintResponseDtoList = paintService.findAll();
        model.addAttribute("paintResponseDtoList", paintResponseDtoList);
        return "paintMain";
    }

    // 그림 등록 페이지
    @GetMapping("/add")
    public String paintAddForm() {
        return "paintAddForm";
    }

    // 그림 등록
    @PostMapping("/add")
    public String paintAdd(@ModelAttribute PaintRequestDto requestDto) throws IOException {
        log.info("paintDto = {}", requestDto);
        paintService.addPaint(requestDto);
        return "redirect:/paint";
    }
}
