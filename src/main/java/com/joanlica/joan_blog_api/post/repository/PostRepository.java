package com.joanlica.joan_blog_api.post.repository;

import com.joanlica.joan_blog_api.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}