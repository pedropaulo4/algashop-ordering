package com.algaworks.algashop.ordering.core.domain.model.customer;

import com.algaworks.algashop.ordering.core.domain.model.commons.Email;
import com.algaworks.algashop.ordering.core.domain.model.commons.FullName;

import java.time.OffsetDateTime;

public record CustomerRegistredEvent(CustomerId  customerId,
                                     OffsetDateTime registred,
                                     FullName fullName,
                                     Email email) {
}
