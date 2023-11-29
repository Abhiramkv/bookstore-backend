package com.abhi.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.bookstore.entity.Book;
import com.abhi.bookstore.entity.MyBookList;
import com.abhi.bookstore.service.BookService;
import com.abhi.bookstore.service.MyBookListService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/available_books")
	public List<Book> getAllBook() {
		List<Book>list=service.getAllBook();
		return list;
	}
	
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book addBook(@RequestBody Book b) {
		return service.save(b);
		
	}
	
	@GetMapping("/my_books")
	public List<MyBookList> getMyBooks(){
		List<MyBookList>list=myBookService.getAllMyBooks();
		return list;
		
	}
	
	@GetMapping("/mylist/{id}")
	public MyBookList getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return mb;		
	}
	
	@PutMapping("/editBook/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Book editBook(@PathVariable("id") int id,@RequestBody Book book) {
		Book oldBook = service.getBookById(id);
		oldBook.setName(book.getName());
		oldBook.setPrice(book.getPrice());
		oldBook.setAuthor(book.getAuthor());
		service.save(oldBook);
		return oldBook;
	}
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		
	}

}
