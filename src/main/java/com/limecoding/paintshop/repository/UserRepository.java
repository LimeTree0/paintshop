package com.limecoding.paintshop.repository;

import com.limecoding.paintshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
