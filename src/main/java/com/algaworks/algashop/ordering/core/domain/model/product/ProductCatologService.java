package com.algaworks.algashop.ordering.core.domain.model.product;

import java.util.Optional;

public interface ProductCatologService {

    Optional<Product> ofId(ProductId productId);
}
