package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ReplyRequestDto;
import com.sparta.springcore.model.Reply;
import com.sparta.springcore.repository.ReplyRepository;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Controller
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    // 댓글 데이터 생성 부분
    @PostMapping("/api/replys")
    public Reply createReply(@RequestBody ReplyRequestDto requestDto){
        Reply reply = new Reply(requestDto);
        return replyRepository.save(reply);
    }

    // 댓글 리스트 출력
    @GetMapping("/api/replys")
    public List<Reply> readReply(){
        return replyRepository.findAllByOrderByModifiedAtDesc();
    }

    // 댓글 삭제
    @DeleteMapping("/api/replys/{id}")
    public Long deleteReply(@PathVariable Long id){
        replyRepository.deleteById(id);
        return id;
    }

    //업데이트
    @PutMapping("/api/replys/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto){
        replyService.update(id, requestDto);
        return id;
    }



}
