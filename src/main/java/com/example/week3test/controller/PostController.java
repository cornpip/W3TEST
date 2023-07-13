package com.example.week3test.controller;

import com.example.week3test.dto.CreatePostRequestDto;
import com.example.week3test.dto.CreatePostResponseDto;
import com.example.week3test.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("")
    public CreatePostResponseDto createPost(@RequestBody CreatePostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("")
    public List<CreatePostResponseDto> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    public CreatePostResponseDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<CreatePostResponseDto> putPostById(@PathVariable Long postId, @RequestBody CreatePostRequestDto requestDto) {
        return postService.putPostById(postId, requestDto);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable Long postId) {
        return postService.deletePostById(postId);
    }

}
