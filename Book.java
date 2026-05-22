package com.example.demo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@NotNull(message = "it shuld be not null")
	private Integer id;
	@NotBlank(message = "it should not be empty")
	private String title;
	@NotBlank(message = "it should not be empty")
	private String author;
	@Positive(message = "price must be greater than 0")
	private double price;

}
