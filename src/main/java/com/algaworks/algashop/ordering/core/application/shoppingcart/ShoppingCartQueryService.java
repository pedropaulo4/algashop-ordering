package com.algaworks.algashop.ordering.core.application.shoppingcart;

import com.algaworks.algashop.ordering.core.ports.in.shoppingcart.ForQueryingShoppingCarts;
import com.algaworks.algashop.ordering.core.ports.in.shoppingcart.ShoppingCartOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingCartQueryService implements ForQueryingShoppingCarts {

    private final ForQueryingShoppingCarts forQueryingShoppingCarts;

    @Override
    public ShoppingCartOutput findById(UUID shoppingCartId) {
        return forQueryingShoppingCarts.findById(shoppingCartId);
    }

    @Override
    public ShoppingCartOutput findByCustomerId(UUID customerId) {
        return forQueryingShoppingCarts.findByCustomerId(customerId);
    }
}
