package com.joanlica.joan_blog_api.core.exception;

public class PostNotFound extends RuntimeException {
    public PostNotFound(String message) {
        super(message);
    }
}