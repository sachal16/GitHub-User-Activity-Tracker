package com.sachal.githubactivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiResponseTest {

    @Test
    void constructorAndGetters() {
        ApiResponse r = new ApiResponse(200, "{\"ok\":true}");
        assertEquals(200, r.getStatusCode());
        assertEquals("{\"ok\":true}", r.getBody());
    }

    @Test
    void errorResponse() {
        ApiResponse r = new ApiResponse(404, "Not Found");
        assertEquals(404, r.getStatusCode());
        assertEquals("Not Found", r.getBody());
    }

    @Test
    void networkError() {
        ApiResponse r = new ApiResponse(-1, "Connection refused");
        assertEquals(-1, r.getStatusCode());
        assertEquals("Connection refused", r.getBody());
    }

    @Test
    void setters() {
        ApiResponse r = new ApiResponse(0, "");
        r.setStatusCode(201);
        r.setBody("created");
        assertEquals(201, r.getStatusCode());
        assertEquals("created", r.getBody());
    }
}
