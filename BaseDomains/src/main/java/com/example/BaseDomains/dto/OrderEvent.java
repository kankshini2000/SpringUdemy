package com.example.BaseDomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEvent {
    private String message;
    private String status;
    private Order order;
}
