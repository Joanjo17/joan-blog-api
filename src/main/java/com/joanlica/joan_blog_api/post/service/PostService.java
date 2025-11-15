package com.joanlica.joan_blog_api.post.service;

import com.joanlica.joan_blog_api.pages.dto.PageResponse;
import com.joanlica.joan_blog_api.post.dto.PostRequestDTO;
import com.joanlica.joan_blog_api.post.dto.PostResponseDTO;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PageResponse<PostResponseDTO> findAll(Pageable pageable);

    PostResponseDTO findPostById(Long id);

    PostResponseDTO createPost(PostRequestDTO newPost);

    PostResponseDTO editPost(Long id, PostRequestDTO newPost);

    void deletePostById(Long id);
}