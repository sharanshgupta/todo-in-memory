package com.sharansh.todo.controller;

import com.sharansh.todo.TodoInMemoryApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(
        classes = TodoInMemoryApplication.class, webEnvironment = RANDOM_PORT)
public class TodoControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnOkResponse() {

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/hello", String.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo("Hello");
    }
}
