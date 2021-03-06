package com.microservice.os.api.common;

import com.microservice.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private String name;
    private Order order;
    private Long amount;
    private String transactionId;
    private String message;
}
