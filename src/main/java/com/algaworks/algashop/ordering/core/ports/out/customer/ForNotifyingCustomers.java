package com.algaworks.algashop.ordering.core.ports.out.customer;

import java.util.UUID;

public interface ForNotifyingCustomers {

    void notifyNewRegistration(NotifyNewRegistrationInput input);

    public record NotifyNewRegistrationInput(UUID customerId, String firstName, String email){}
}
