package com.github.murilojatoba.unyleya_ecommerce_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document(collection = "Produtos")
public class Produto {
	
	@Transient 
	public static final String SEQUENC_NAME = "produto_sequence"; 
	
	@Id
	private Long id;
	
	@NotNull
	@Indexed(unique = true)
	private Long codigo;
	
	@NotNull
	@Size(max = 500)
	@Indexed(unique = true)
	private String nome;
	
	@NotNull
	private Double preco;
	
	public Produto() {}
	
	public Produto(Long codigo, String nome, Double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
}
