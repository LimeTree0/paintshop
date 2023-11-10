package com.limecoding.paintshop.service;

import com.limecoding.paintshop.domain.Board;
import com.limecoding.paintshop.dto.BoardResponseDto;
import com.limecoding.paintshop.dto.BoardRequestDto;
import com.limecoding.paintshop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public void save(BoardRequestDto boardRequestDto) {
        Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .author(boardRequestDto.getAuthor())
                .content(boardRequestDto.getContent())
                .build();
        boardRepository.save(board);
    }

    public BoardResponseDto findById(Long id) throws IllegalAccessException {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("해당하는 게시글이 존재하지 않습니다."));

        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getAuthor(),
                board.getContent()
        );
    }

    @Transactional
    public Long update(Long id, BoardRequestDto boardRequestDto) throws IllegalAccessException {
        Board board = boardRepository.findById(id).orElseThrow(IllegalAccessException::new);

        board.update(boardRequestDto.getTitle(), boardRequestDto.getContent());
        log.info("Update Board result = {}", board);
        return board.getId();
    }

    public void delete(Long id) throws IllegalAccessException {
        Board board = boardRepository.findById(id).orElseThrow(IllegalAccessException::new);
        boardRepository.delete(board);

    }
}
