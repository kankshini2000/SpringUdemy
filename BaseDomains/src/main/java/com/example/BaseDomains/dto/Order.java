package com.example.BaseDomains.dto;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private String name;
    private int qty;
    private double price;
}
