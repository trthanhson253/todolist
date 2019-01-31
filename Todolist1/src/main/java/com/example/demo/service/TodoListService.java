package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TodoList;

public interface TodoListService {
	
	Iterable<TodoList> findAll();
	
	List<TodoList> search(String q);
	
	TodoList findOne(int id);
	
	void save(TodoList todoList);
	
	void delete(int id);

}
