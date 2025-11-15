package com.joanlica.joan_blog_api.post.service.implementation;

import com.joanlica.joan_blog_api.core.exception.PostNotFoundException;
import com.joanlica.joan_blog_api.pages.dto.PageResponse;
import com.joanlica.joan_blog_api.post.dto.PostRequestDTO;
import com.joanlica.joan_blog_api.post.dto.PostResponseDTO;
import com.joanlica.joan_blog_api.post.model.Post;
import com.joanlica.joan_blog_api.post.repository.PostRepository;
import com.joanlica.joan_blog_api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public PageResponse<PostResponseDTO> findAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        Page<PostResponseDTO> postsResponse = posts.map(PostResponseDTO::fromPost);
        return PageResponse.from(postsResponse);
    }

    private Post findPostEntityById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("asda"));
    }
    @Override
    public PostResponseDTO findPostById(Long id) {
        Post post = this.findPostEntityById(id);
        return PostResponseDTO.fromPost(post);
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO newPost) {
        // Creating a new post
        Post post = new Post();
        post.setTitle(newPost.title());
        post.setContent(newPost.content());
        post.setAuthor(newPost.author());
        post.setCreatedAt(LocalDate.now());
        post.setUpdatedAt(LocalDate.now());
        // Saving post
        Post savedPost = postRepository.save(post);

        return PostResponseDTO.fromPost(savedPost);
    }

    @Override
    public PostResponseDTO editPost(Long id, PostRequestDTO newPost) {
        //Find post
        Post post = this.findPostEntityById(id);

        // Updating post
        post.setTitle(newPost.title());
        post.setContent(newPost.content());
        post.setAuthor(newPost.author());
        post.setUpdatedAt(LocalDate.now());
        // Saving post
        Post savedPost = postRepository.save(post);

        return PostResponseDTO.fromPost(savedPost);
    }

    @Override
    public void deletePostById(Long id) {
        //Find post first, then delete
        this.findPostEntityById(id);

        postRepository.deleteById(id);
    }
}