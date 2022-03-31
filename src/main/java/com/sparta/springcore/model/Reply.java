package com.sparta.springcore.model;

import com.sparta.springcore.dto.ReplyRequestDto;
import com.sparta.springcore.dto.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Reply<queryString> extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String replyusername;

    @Column(nullable = false)
    private String replycoment;

    @Column(nullable = false)
    private String boardid;


    public Reply(String replyusername, String replycoment, String boardid) {
        this.replyusername = replyusername;
        this.replycoment = replycoment;
        this.boardid = boardid;
    }

    public Reply(ReplyRequestDto requestDto) {
        this.replyusername = requestDto.getReplyusername();
        this.replycoment = requestDto.getReplycontents();
        this.boardid = requestDto.getBoardid();
    }

    public void update(ReplyRequestDto requestDto) {
        this.replyusername = requestDto.getReplyusername();
        this.replycoment = requestDto.getReplycontents();
        this.boardid = requestDto.getBoardid();

    }


}
