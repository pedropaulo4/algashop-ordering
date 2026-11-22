package com.algaworks.algashop.ordering.core.domain.model.product;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductCatalogService {

    Optional<Product> ofId(ProductId productId);
}
