package com.algaworks.algashop.ordering.infrastructure.fake;

import com.algaworks.algashop.ordering.domain.model.service.ProductCatologService;
import com.algaworks.algashop.ordering.domain.model.valueobject.Money;
import com.algaworks.algashop.ordering.domain.model.valueobject.Product;
import com.algaworks.algashop.ordering.domain.model.valueobject.ProductName;
import com.algaworks.algashop.ordering.domain.model.valueobject.id.ProductId;

import java.util.Optional;

public class ProductCatalogService implements ProductCatologService {
    @Override
    public Optional<Product> ofId(ProductId productId) {
        Product product = Product.builder()
                .id(productId)
                .inStock(true)
                .name(new ProductName("Notebook"))
                .price(new Money("3000"))
                .build();

        return Optional.of(product);
    }
}
