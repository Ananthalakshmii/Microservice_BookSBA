package com.accolite;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service")
public interface BookProxy {

	@GetMapping("/bookservice/getbookcost/{bookName}")
	public Student getBookCost(@PathVariable String bookName);
	
}
