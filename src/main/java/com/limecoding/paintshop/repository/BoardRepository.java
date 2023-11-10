package com.limecoding.paintshop.repository;

import com.limecoding.paintshop.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
