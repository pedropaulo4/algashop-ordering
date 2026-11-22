package com.algaworks.algashop.ordering.core.ports.in.order;

import com.algaworks.algashop.ordering.core.ports.in.commons.AddressData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingInput {

    private RecipientData recipient;
    private AddressData address;
}
