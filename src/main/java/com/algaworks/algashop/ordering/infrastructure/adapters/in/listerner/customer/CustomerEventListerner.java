package com.algaworks.algashop.ordering.infrastructure.adapters.in.listerner.customer;

import com.algaworks.algashop.ordering.core.ports.in.customer.ForAddingLoyaltyPoints;
import com.algaworks.algashop.ordering.core.ports.in.customer.ForConfirmCustomerRegistration;
import com.algaworks.algashop.ordering.core.ports.out.customer.ForNotifyingCustomers;
import com.algaworks.algashop.ordering.core.domain.model.customer.CustomerArchivedEvent;
import com.algaworks.algashop.ordering.core.domain.model.customer.CustomerRegistredEvent;
import com.algaworks.algashop.ordering.core.domain.model.order.OrderReadyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerEventListerner {

    private final ForConfirmCustomerRegistration forConfirmCustomerRegistration;

    private final ForAddingLoyaltyPoints forAddingLoyaltyPoints;

    @EventListener
    public void listen(CustomerRegistredEvent event) {
        log.info("CustomerRegistredEvent listen 1");
        forConfirmCustomerRegistration.confirm(event.customerId().value());

    }

    @EventListener
    public void listen(CustomerArchivedEvent event) {
        log.info("CustomerArchivedEvent listen 1");
    }

    @EventListener
    public void listen(OrderReadyEvent event) {

        forAddingLoyaltyPoints.addLoyaltyPoints(event.customerId().value(),
                event.orderId().value().toString());

    }
}
