package com.example.week3test.service;

import com.example.week3test.dto.CreatePostRequestDto;
import com.example.week3test.dto.CreatePostResponseDto;
import com.example.week3test.entity.Item;
import com.example.week3test.repository.ItemRepository;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private ItemRepository itemRepository;

    public CreatePostResponseDto createPost(CreatePostRequestDto requestDto) {
        Item save = itemRepository.save(new Item(requestDto));
        return new CreatePostResponseDto(save);
    }

    public CreatePostResponseDto getPostById(Long postId) {
        Optional<Item> item = itemRepository.findById(postId);
        return item.map(CreatePostResponseDto::new).orElse(null);
    }

    public List<CreatePostResponseDto> getAllPost() {
        List<Item> all = itemRepository.findAll();
        return all.stream().map(CreatePostResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ResponseEntity<CreatePostResponseDto> putPostById(Long postId, CreatePostRequestDto requestDto) {
        Optional<Item> itemOptional = itemRepository.findById(postId);
        if (itemOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreatePostResponseDto());
        Item updateItem = itemOptional.get().update(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(new CreatePostResponseDto(updateItem));
    }

    public ResponseEntity<String> deletePostById(Long postId) {
        Optional<Item> itemOptional = itemRepository.findById(postId);
        if (itemOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"msg\" : \"없는 Post 입니다.\"}");
        itemRepository.delete(itemOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("{\"msg\" : \"삭제 완료\"}");
    }
}
