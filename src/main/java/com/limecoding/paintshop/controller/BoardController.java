package com.limecoding.paintshop.controller;

import com.limecoding.paintshop.domain.Board;
import com.limecoding.paintshop.dto.BoardResponseDto;
import com.limecoding.paintshop.dto.BoardRequestDto;
import com.limecoding.paintshop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String board(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);

        return "board";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable Long id, Model model) throws IllegalAccessException {
        BoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("responseDto", responseDto);

        return "boardDetail";
    }

    @GetMapping("/add")
    public String boardAddForm() {
        return "boardAddForm";
    }

    @PostMapping("/add")
    public String boardAdd(@ModelAttribute BoardRequestDto boardRequestDto) {
        boardService.save(boardRequestDto);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String boardUpdateForm(@PathVariable Long id, Model model) throws IllegalAccessException {
        BoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("responseDto", responseDto);

        return "boardUpdateForm";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(@PathVariable Long id, @ModelAttribute BoardRequestDto requestDto) throws IllegalAccessException {
        boardService.update(id, requestDto);

        return "redirect:/board/" + id;
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable Long id) throws IllegalAccessException {
        boardService.delete(id);

        return "redirect:/board/";
    }

}
