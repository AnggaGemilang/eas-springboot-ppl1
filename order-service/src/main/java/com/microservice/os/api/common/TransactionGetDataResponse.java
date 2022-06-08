package com.microservice.os.api.common;

import com.microservice.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionGetDataResponse {
    private List<Order> order;
}
