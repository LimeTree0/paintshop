package com.limecoding.paintshop.service;

import com.limecoding.paintshop.domain.Paint;
import com.limecoding.paintshop.dto.PaintResponseDto;
import com.limecoding.paintshop.dto.PaintRequestDto;
import com.limecoding.paintshop.repository.PaintRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaintService {

    private final PaintRepository paintRepository;

    // 파일의 저장 절대 경로(properties 파일에 선언되어 있음)
    @Value("${img.dir}")
    private String imgDir;

    public void addPaint(PaintRequestDto paintRequestDto) throws IOException {

        Paint paint = new Paint();
        paint.setTitle(paintRequestDto.getTitle());
        paint.setPrice(paintRequestDto.getPrice());
        paint.setAuthor(paintRequestDto.getAuthor());
        paint.setSubscribe(paintRequestDto.getSubscribe());

        if (!paintRequestDto.getImage().isEmpty()) {
            MultipartFile img = paintRequestDto.getImage();
            String fullPath = imgDir + img.getOriginalFilename();
            paint.setFilePath(fullPath);
            log.info("이미지 저장 경로 = {}", fullPath);
            img.transferTo(new File(fullPath));
        }

        paintRepository.save(paint);
    }
    
    public PaintResponseDto findById(Long id) {
        Optional<Paint> paint = paintRepository.findById(id);
        if(paint.isPresent()) {
            PaintResponseDto paintResponseDto = new PaintResponseDto();
            paintResponseDto.setAuthor(paint.get().getAuthor());
            paintResponseDto.setTitle(paint.get().getTitle());
            paintResponseDto.setSubscribe(paint.get().getSubscribe());
            paintResponseDto.setPrice(paint.get().getPrice());
            paintResponseDto.setFilePath(paint.get().getFilePath());

            return paintResponseDto;
        }
        return null;
    }

    public List<PaintResponseDto> findAll() {
        List<PaintResponseDto> responseDtos = new ArrayList<>();
        List<Paint> paints = paintRepository.findAll();

        for (Paint paint : paints) {
            PaintResponseDto dto = new PaintResponseDto();
            dto.setTitle(paint.getTitle());
            dto.setAuthor(paint.getAuthor());
            dto.setSubscribe(paint.getSubscribe());
            dto.setPrice(paint.getPrice());
            dto.setFilePath(paint.getFilePath());
            responseDtos.add(dto);
        }

        return responseDtos;

    }
}
