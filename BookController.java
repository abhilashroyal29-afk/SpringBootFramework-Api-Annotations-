package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import jakarta.validation.Valid;

@RestController
@Validated

public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")
	
	public List<Book> getBooks() {
		
		return bookservice.getBooks();
		
	}
	@GetMapping("/books/{id}")
	
	public Book getBookbyId(@PathVariable int id) {
		return bookservice.getBookbyId(id);
		
	}
	@PostMapping("/books")
	
	public Book addBook(@Valid @RequestBody Book book) {
		
		return bookservice.addBook(book);
		
	}
	@PutMapping("/books/{id}")
	 public Book updateBook(@PathVariable int id,@Valid @RequestBody Book book) {
		return bookservice.updateBook(id,book);
		
	}
	@PatchMapping("/books/{id}")
	 public Book patcBook(@PathVariable int id,@RequestBody Book book) {
		return bookservice.patchBook(id,book);
	}
	@DeleteMapping("/books/{id}")
		
		public String deleteBook(@PathVariable int id) {
		
			return bookservice.deleteBook(id);
		
	}

}
