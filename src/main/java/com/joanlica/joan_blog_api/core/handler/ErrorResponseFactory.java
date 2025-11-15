package com.joanlica.joan_blog_api.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ErrorResponseFactory {
    // Payload común para errores
    public Map<String, Object> payload(String error,
                                       String message,
                                       String path,
                                       Map<String, Object> details) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("error", error);
        m.put("message", message);
        m.put("path", path);
        m.put("timestamp", OffsetDateTime.now().toString());
        if (details != null && !details.isEmpty()) m.put("details", details);
        return m;
    }

    // ResponseEntity para el @RestControllerAdvice
    public ResponseEntity<Object> entity(HttpStatus status,
                                         String error,
                                         String message,
                                         String path,
                                         Map<String, Object> details) {
        return ResponseEntity.status(status).body(payload(error, message, path, details));
    }
}