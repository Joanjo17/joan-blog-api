package com.joanlica.joan_blog_api.post.controller;

import com.joanlica.joan_blog_api.pages.dto.PageResponse;
import com.joanlica.joan_blog_api.post.dto.PostRequestDTO;
import com.joanlica.joan_blog_api.post.dto.PostResponseDTO;
import com.joanlica.joan_blog_api.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<PageResponse<PostResponseDTO>> getAllPosts(@PageableDefault Pageable pageable) {
        PageResponse<PostResponseDTO> postList = postService.findAll(pageable);
        return ResponseEntity.ok(postList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        PostResponseDTO postResponse = postService.findPostById(id);
        return ResponseEntity.ok(postResponse);
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponse = postService.createPost(postRequestDTO);
        URI location = URI.create("/api/v1/posts/" + postResponse.id());
        return ResponseEntity.created(location).body(postResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long id, @Valid @RequestBody PostRequestDTO postRequestDTO) {
        PostResponseDTO postResponse = postService.editPost(id,postRequestDTO);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
}