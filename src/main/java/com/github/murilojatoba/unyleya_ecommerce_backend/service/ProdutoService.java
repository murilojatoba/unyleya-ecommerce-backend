package com.github.murilojatoba.unyleya_ecommerce_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.murilojatoba.unyleya_ecommerce_backend.model.Produto;
import com.github.murilojatoba.unyleya_ecommerce_backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepository produtoRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	public Produto getById(Long id) throws Exception {
		Produto produto = this.produtoRepository.findById(id)
				.orElseThrow(() -> new Exception("Produto não encontrado."));

		return produto;
	}

	public Produto createProduto(Produto produto) {
		produto.setId(sequenceGeneratorService.generateSequence(Produto.SEQUENC_NAME));
		return produtoRepository.save(produto);
	}

	public Produto updateProduto(Long id, Produto produto) throws Exception {
		if (!produto.getId().equals(id)) {
			throw new Exception("Produto não corresponde ao id informado");
		}

		Produto produtoBanco = this.produtoRepository.findById(id)
				.orElseThrow(() -> new Exception("Produto não encontrado."));

		produtoBanco.setCodigo(produto.getCodigo());
		produtoBanco.setNome(produto.getNome());
		produtoBanco.setPreco(produto.getPreco());

		return produtoRepository.save(produtoBanco);
	}

	public void deleteProduto(Long id) throws Exception {
		Produto produto = this.produtoRepository.findById(id)
				.orElseThrow(() -> new Exception("Produto não encontrado."));

		this.produtoRepository.delete(produto);
	}
}
