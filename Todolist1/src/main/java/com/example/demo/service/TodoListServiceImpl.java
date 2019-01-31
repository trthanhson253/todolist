package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService {
	@Autowired
	private TodoListRepository todolistRepository;

	@Override
	public Iterable<TodoList> findAll() {
		return todolistRepository.findAll();
	}

	@Override
	public List<TodoList> search(String q) {
		// TODO Auto-generated method stub
		return todolistRepository.findByTextIgnoreCaseContaining(q);
	}

	@Override
	public TodoList findOne(int id) {
		return todolistRepository.findOne(id);
	}

	@Override
	public void save(TodoList todoList) {
		todolistRepository.save(todoList);
		
	}

	@Override
	public void delete(int id) {
		todolistRepository.delete(id);
		
	}
	
	
	
	
}
