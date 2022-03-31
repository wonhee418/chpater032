package com.sparta.springcore.service;

import com.sparta.springcore.dto.ReplyRequestDto;
import com.sparta.springcore.model.Reply;
import com.sparta.springcore.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public Long update(Long id, ReplyRequestDto requestDto) {
        Reply reply = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        reply.update(requestDto);
        return reply.getId();
    }


}
