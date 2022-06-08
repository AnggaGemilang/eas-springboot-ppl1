package com.microservice.os.api.controller;

import com.microservice.os.api.common.TransactionGetDataResponse;
import com.microservice.os.api.common.TransactionRequest;
import com.microservice.os.api.common.TransactionResponse;
import com.microservice.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/doOrder")
    public TransactionResponse doOrder(@RequestBody TransactionRequest request){
        return service.saveOrder(request);
    }
    @GetMapping("/")
    private TransactionGetDataResponse getDataOrder(){return service.getDataOrder();}
}
