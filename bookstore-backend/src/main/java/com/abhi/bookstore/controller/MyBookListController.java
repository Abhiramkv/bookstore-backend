package com.abhi.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.bookstore.service.MyBookListService;

@RestController
public class MyBookListController {
	@Autowired
	private MyBookListService service;
	
	@RequestMapping("/deleteMyList/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		
	}

}
