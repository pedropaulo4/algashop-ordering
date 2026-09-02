package com.algaworks.algashop.ordering.infrastructure.product.client.fake;

import com.algaworks.algashop.ordering.domain.model.product.ProductCatologService;
import com.algaworks.algashop.ordering.domain.model.commons.Money;
import com.algaworks.algashop.ordering.domain.model.product.Product;
import com.algaworks.algashop.ordering.domain.model.product.ProductName;
import com.algaworks.algashop.ordering.domain.model.product.ProductId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
