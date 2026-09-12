package com.algaworks.algashop.ordering.application.order.query;

import com.algaworks.algashop.ordering.application.utility.PageFilter;
import org.springframework.data.domain.Page;


import java.util.UUID;

public interface OrderQueryService {

    OrderDetailOutput findById(String id);
    Page<OrderSummaryOutput> filter(OrderFilter filter);
}
