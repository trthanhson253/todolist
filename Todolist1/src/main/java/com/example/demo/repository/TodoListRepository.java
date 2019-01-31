package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TodoList;
public interface TodoListRepository extends JpaRepository<TodoList,Integer> {
	List<TodoList> findByTextIgnoreCaseContaining(String text);
}
