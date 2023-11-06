package com.limecoding.paintshop.repository;

import com.limecoding.paintshop.domain.Paint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintRepository extends JpaRepository<Paint, Long> {
}
