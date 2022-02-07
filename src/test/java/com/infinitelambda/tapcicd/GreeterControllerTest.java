package com.infinitelambda.tapcicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreeterControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greet() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/greet/user", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hi, User!", response.getBody());
    }

    @Test
    void greet_withoutParameter() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/greet", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hi user", response.getBody());
    }
}
