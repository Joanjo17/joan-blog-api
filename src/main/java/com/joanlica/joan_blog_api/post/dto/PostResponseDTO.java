package com.joanlica.joan_blog_api.post.dto;

import com.joanlica.joan_blog_api.post.model.Post;

public record PostResponseDTO(
        Long id,
        String title,
        String content,
        String author,
        String createdAt,
        String updatedAt
) {
    public static PostResponseDTO fromPost(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getCreatedAt().toString(),
                post.getUpdatedAt().toString()
        );
    }
}