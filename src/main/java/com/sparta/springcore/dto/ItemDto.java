package com.sparta.springcore.dto;

import lombok.Getter;

@Getter
// 네이버 api 상품 벨류값
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;
}