package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

import jakarta.validation.Valid;

@Service
public class BookService {
	
	private List<Book> blist = new ArrayList<>(Arrays.asList(
		    new Book(101, "Java Complete Reference", "Herbert", 550.0),
		    new Book(102, "Spring Boot in Action", " Walls", 720.5),
		    new Book(103, "Clean Code", " Martin", 890.0)
		));

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return blist;
	}

	public Book getBookbyId(int id) {
		// TODO Auto-generated method stub
		
		for(Book b:blist) {
			if(b.getId()== id) {
				return b;
			}
		}
		
		return null;
	}

	public Book addBook(@Valid Book book) {
		// TODO Auto-generated method stub
		blist.add(book);
		return book;
	}

	public Book updateBook(int id,@Valid Book updateBook) {
		// TODO Auto-generated method stub
		for(Book b:blist) {
			if(b.getId()==id) {
				b.setTitle(updateBook.getTitle());
				b.setAuthor(updateBook.getAuthor());
				b.setPrice(updateBook.getPrice());
				return b;
			}
		}
		return null;
	}

	public Book patchBook(int id,Book paBook) {
		// TODO Auto-generated method stub
		for(Book b:blist) {
			if(b.getId()==id) {
				if(paBook.getTitle() !=null) {
					b.setTitle(paBook.getTitle());
				}
				if(paBook.getAuthor() !=null) {
					b.setAuthor(paBook.getAuthor());
				}
				if(paBook.getPrice() !=0.0) {
					b.setPrice(paBook.getPrice());
				}
				return b;
			}
		}
		
		return null;
	
	}

	public String deleteBook(int id) {
		// TODO Auto-generated method stub
		for(Book b:blist) {
			if(b.getId()==id) {
				blist.remove(b);
				return "Book delted";
			}
		}
			
		
		return "Book not Found";
	}

}
