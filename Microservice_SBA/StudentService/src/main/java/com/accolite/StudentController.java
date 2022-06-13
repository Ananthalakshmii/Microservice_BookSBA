package com.accolite;



import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/studentservice")
public class StudentController {
	
	
	@Autowired
	private BookProxy bookProxy;
	
	
	@GetMapping("/findCost/{bookName}/quantity/{quantity}")
	public Student findCostOfBookPurchased(@PathVariable String bookName, @PathVariable Integer quantity) {
		Student student=bookProxy.getBookCost(bookName);
		System.out.println();
		return new Student(student.getBookId(), bookName, student.getBookCost(), quantity*student.getBookCost(),student.getEnvironment());
	}

}
