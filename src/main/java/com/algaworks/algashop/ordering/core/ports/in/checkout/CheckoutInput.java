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
public class CheckoutInput {
	private UUID shoppingCartId;
	private String paymentMethod;
	private ShippingInput shipping;
	private BillingData billing;
	private UUID creditCardId;
}