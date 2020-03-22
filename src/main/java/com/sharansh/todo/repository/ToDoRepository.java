package com.sharansh.todo.repository;

import com.sharansh.todo.domain.ToDo;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository implements CommonRepository<ToDo> {

    private Map<String, ToDo> toDos = new HashMap<>();


    @Override
    public ToDo save(ToDo domain) {
        ToDo existing = toDos.get(domain.getId());
    System.out.println("ToDo - " + existing.toString());
        if(Objects.nonNull(existing)) {
            existing.setCreated(LocalDateTime.now());
            existing.setModified(LocalDateTime.now());
            existing.setCompleted(domain.isCompleted());
            domain = existing;
        }
        toDos.put(domain.getId(), domain);
        System.out.println("Saved - " + domain.getId());
        return toDos.get(domain.getId());
    }

    @Override
    public Iterable<ToDo> save(Collection<ToDo> domains) {
        return null;
    }

    @Override
    public void delete(ToDo domain) {

    }

    @Override
    public ToDo findById(String id) {
        return toDos.get(id);
    }

    @Override
    public Iterable<ToDo> findAll() {
//        return (Iterable<ToDo>) toDos;
        return toDos.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
