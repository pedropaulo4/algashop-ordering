package com.algaworks.algashop.ordering.infrastructure.listener.customer;

import com.algaworks.algashop.ordering.application.customer.loyaltypoints.CustomerLoyaltyPointsApplicationService;
import com.algaworks.algashop.ordering.application.customer.notification.CustomerNotificationApplicationService;
import com.algaworks.algashop.ordering.domain.model.commons.Email;
import com.algaworks.algashop.ordering.domain.model.commons.FullName;
import com.algaworks.algashop.ordering.domain.model.customer.CustomerId;
import com.algaworks.algashop.ordering.domain.model.customer.CustomerRegistredEvent;
import com.algaworks.algashop.ordering.domain.model.order.OrderId;
import com.algaworks.algashop.ordering.domain.model.order.OrderReadyEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.algaworks.algashop.ordering.application.customer.notification.CustomerNotificationApplicationService.NotifyNewRegistrationInput;

@SpringBootTest
public class CustomerEventListenerIT {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockitoSpyBean
    private CustomerEventListerner customerEventListerner;

    @MockitoBean
    private CustomerLoyaltyPointsApplicationService customerLoyaltyPointsApplicationService;

    @MockitoBean
    private CustomerNotificationApplicationService customerNotificationApplicationService;

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
