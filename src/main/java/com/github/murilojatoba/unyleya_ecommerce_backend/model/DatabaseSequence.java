package com.github.murilojatoba.unyleya_ecommerce_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "database-sequences")
public class DatabaseSequence {

	@Id
	private String id;
	
	@NotNull
	private long seq;
}
