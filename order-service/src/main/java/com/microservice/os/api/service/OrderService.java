package com.microservice.os.api.service;

import com.microservice.os.api.common.*;
import com.microservice.os.api.entity.Catalog;
import com.microservice.os.api.entity.Order;
import com.microservice.os.api.entity.Payment;
import com.microservice.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate template;
    public TransactionResponse saveOrder(TransactionRequest request){
        String message;
        Order order = request.getOrder();

        Catalog catalog = new Catalog();
        CatalogByIdResponse responseCatalog = template.getForObject("http://CATALOG-SERVICE/catalog/"+order.getCatalogId(),CatalogByIdResponse.class);
        catalog.setCatalogId(order.getCatalogId());
        catalog.setStock(responseCatalog.getCatalog().getStock() - order.getQty());
        catalog.setPrice(responseCatalog.getCatalog().getPrice());
        catalog.setName(responseCatalog.getCatalog().getName());

        if(responseCatalog.getCatalog().getStock() - order.getQty() <= 0){
            return new TransactionResponse("", null, 0L, "", "Stok habis");
        }

        template.postForObject("http://CATALOG-SERVICE/catalog/updateStok", catalog, Catalog.class);

        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(responseCatalog.getCatalog().getPrice()*order.getQty());
        Payment response = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);

        message = response.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is an eror occured, order placed in cart";
        repository.save(order);
        return new TransactionResponse(responseCatalog.getCatalog().getName(),order, response.getAmount(), response.getTransactionId(), message);
    }

    public TransactionGetDataResponse getDataOrder(){
        List<Order> order = repository.findAll();
        return new TransactionGetDataResponse(order);
    }

}
