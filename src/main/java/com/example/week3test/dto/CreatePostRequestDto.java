package com.example.week3test.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreatePostRequestDto {
    private String title;
    private String content;
    private Integer price;
    private String username;
}
