package com.github.murilojatoba.unyleya_ecommerce_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.github.murilojatoba.unyleya_ecommerce_backend.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {

}
