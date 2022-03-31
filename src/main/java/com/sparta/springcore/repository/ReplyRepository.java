package com.sparta.springcore.repository;

import com.sparta.springcore.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByOrderByModifiedAtDesc();
}
