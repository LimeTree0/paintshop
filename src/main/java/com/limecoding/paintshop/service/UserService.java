package com.limecoding.paintshop.service;

import com.limecoding.paintshop.domain.User;
import com.limecoding.paintshop.dto.JoinDto;
import com.limecoding.paintshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long registerUser(JoinDto joinDto) {
        log.info("[UserService] joinDto={}", joinDto);
        User user = new User(joinDto.getMemberId(), joinDto.getPassword());
        User save = userRepository.save(user);
        return save.getId();
    }

}
