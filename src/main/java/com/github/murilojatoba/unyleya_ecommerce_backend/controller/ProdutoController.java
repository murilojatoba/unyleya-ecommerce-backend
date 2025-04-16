package com.github.murilojatoba.unyleya_ecommerce_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.murilojatoba.unyleya_ecommerce_backend.model.Produto;
import com.github.murilojatoba.unyleya_ecommerce_backend.service.ProdutoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("produtos/")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/")
	public List<Produto> getAllProdutos() {
		return produtoService.getAllProdutos();
	}

	@GetMapping("/{id}")
	public Produto getById(@PathVariable("id") @NotNull Long id) throws Exception {
		return produtoService.getById(id);
	}

	@PostMapping("/")
	public Produto createProduto(@Valid @RequestBody Produto produto) {
		return produtoService.createProduto(produto);
	}

	@PutMapping("/{id}")
	public Produto updateProduto(@PathVariable("id") @NotNull Long id, @Valid @RequestBody Produto produto)
			throws Exception {
		return produtoService.updateProduto(id, produto);
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable("id") @NotNull Long id) throws Exception {
		this.produtoService.deleteProduto(id);
	}
}
