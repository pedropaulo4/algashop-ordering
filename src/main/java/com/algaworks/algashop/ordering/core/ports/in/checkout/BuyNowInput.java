package com.algaworks.algashop.ordering.core.ports.in.checkout;


import com.algaworks.algashop.ordering.core.ports.in.order.ShippingInput;
import com.algaworks.algashop.ordering.core.ports.in.order.BillingData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyNowInput {

    private ShippingInput shipping;
    private BillingData billing;
    private UUID productId;
    private UUID customerId;
    private Integer quantity;
    private String paymentMethod;
    private UUID creditCardId;

}
