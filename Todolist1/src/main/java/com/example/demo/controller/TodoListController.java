package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.TodoList;
import com.example.demo.service.TodoListService;

@Controller
public class TodoListController {
	@Autowired
	private TodoListService todolistService;
	
	@GetMapping("/view")
	public String index(Model model) {
		model.addAttribute("list",todolistService.findAll());
		return "list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("todoList",new TodoList());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid TodoList todoList,BindingResult result,RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "form";
		}
		todolistService.save(todoList);
		redirect.addFlashAttribute("success", "Created a new work successfully!");
		return "redirect:/view";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		todolistService.delete(id);
	    redirect.addFlashAttribute("success", "Deleted successfully!");
	    return "redirect:/view";
	 }
	@GetMapping("/search")
	public String search(@RequestParam("q") String q, Model model,RedirectAttributes redirect) {
	    if (q.equals("")) {
	    	redirect.addFlashAttribute("success", "0 result");
	        return "redirect:/view";
	    }

	    model.addAttribute("list", todolistService.search(q));
	    model.addAttribute("count", todolistService.search(q).size());
	    return "list";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
	    model.addAttribute("todoList", todolistService.findOne(id));
	    return "form";
	}
}
