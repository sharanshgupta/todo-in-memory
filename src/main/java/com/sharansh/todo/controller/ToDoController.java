package com.sharansh.todo.controller;

import com.sharansh.todo.domain.ToDo;
import com.sharansh.todo.repository.CommonRepository;
import com.sharansh.todo.validation.ToDoValidationError;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
@Log4j
public class ToDoController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    private CommonRepository<ToDo> repository;

    int x =2;

    @Autowired
    public ToDoController(CommonRepository<ToDo> repository) {
        this.repository = repository;
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping("/todo")
    public ResponseEntity<Iterable<ToDo>> getToDos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() throws RuntimeException {
        if(x == 1) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok("Hello");
    }

    @RequestMapping(value = "/todo", method = POST)
    public ResponseEntity<?> createToDo(@Valid @RequestBody ToDo todo) {
        ToDo result = repository.save(todo);
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler
    public ToDoValidationError handleException(Exception exception) {
        log.error(exception.getMessage());
        return new ToDoValidationError(exception.getMessage());
    }


}
