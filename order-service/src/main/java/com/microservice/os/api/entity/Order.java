package com.microservice.os.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;

@Entity
@Table(name = "t_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Integer id;
    private Integer qty;
    private Integer catalogId;
}
