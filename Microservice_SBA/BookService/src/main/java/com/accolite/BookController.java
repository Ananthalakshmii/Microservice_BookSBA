package com.accolite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bookservice")
@Slf4j
public class BookController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/")
	public Book saveBook(@RequestBody Book book) {
		log.info("Saving book details");
		String port=env.getProperty("local.server.port");
		book.setEnvironment(port);
		return bookRepository.save(book);
	}
	
	@GetMapping("/getbookcost/{bookName}")
	public Book getBookCost(@PathVariable String bookName) {
		log.info("Getting cost of the book "+bookName);
		String port=env.getProperty("local.server.port");
		Book book= bookRepository.findCostByBookName(bookName);
		book.setEnvironment(port);
		return book;
	}
	
	

}
