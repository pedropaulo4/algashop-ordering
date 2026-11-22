package com.algaworks.algashop.ordering.infrastructure.adapters.in.listerner.customer;

import com.algaworks.algashop.ordering.core.application.AbstractApplicationIT;

import com.algaworks.algashop.ordering.core.application.customer.CustomerLoyaltyPointsApplicationService;
import com.algaworks.algashop.ordering.core.ports.out.customer.ForNotifyingCustomers;
import com.algaworks.algashop.ordering.core.domain.model.commons.Email;
import com.algaworks.algashop.ordering.core.domain.model.commons.FullName;
import com.algaworks.algashop.ordering.core.domain.model.customer.CustomerId;
import com.algaworks.algashop.ordering.core.domain.model.customer.CustomerRegistredEvent;
import com.algaworks.algashop.ordering.core.domain.model.order.OrderId;
import com.algaworks.algashop.ordering.core.domain.model.order.OrderReadyEvent;
import com.algaworks.algashop.ordering.infrastructure.adapters.in.listerner.customer.CustomerEventListerner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.algaworks.algashop.ordering.core.ports.out.customer.ForNotifyingCustomers.NotifyNewRegistrationInput;

public class CustomerEventListenerIT extends AbstractApplicationIT {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockitoSpyBean
    private CustomerEventListerner customerEventListerner;

    @MockitoBean
    private CustomerLoyaltyPointsApplicationService customerLoyaltyPointsApplicationService;

    @MockitoBean
    private ForNotifyingCustomers customerNotificationApplicationService;

    @Test
    public void shouldListenOrderReadyEvent() {
        applicationEventPublisher.publishEvent(
                new OrderReadyEvent(
                        new OrderId(),
                        new CustomerId(),
                        OffsetDateTime.now()
                )
        );

        Mockito.verify(customerEventListerner).listen(Mockito.any(OrderReadyEvent.class));

        Mockito.verify(customerLoyaltyPointsApplicationService).addLoyaltyPoints(
                Mockito.any(UUID.class),
                Mockito.any(String.class));
    }

    @Test
    public void shouldListenCustomerRegistredEvent() {

        applicationEventPublisher.publishEvent(
                new CustomerRegistredEvent(
                        new CustomerId(),
                        OffsetDateTime.now(),
                        new FullName("John", "Doe"),
                        new Email("john.doe@email.com")
                )
        );

        Mockito.verify(customerEventListerner).listen(Mockito.any(CustomerRegistredEvent.class));

        Mockito.verify(customerNotificationApplicationService).notifyNewRegistration(
                Mockito.any(NotifyNewRegistrationInput.class));

    }

}
