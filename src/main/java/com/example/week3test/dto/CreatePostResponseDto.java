package com.example.week3test.dto;

import com.example.week3test.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class CreatePostResponseDto {
    private Long id;
    private String title;
    private String content;
    private Integer price;
    private String username;

    public CreatePostResponseDto(Item item){
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
