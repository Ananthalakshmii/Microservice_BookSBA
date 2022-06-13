package com.accolite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	
	private Integer bookId;
	private String bookName;
	private Double bookCost;
	private Double totalCost;
	private String environment;
	

}
