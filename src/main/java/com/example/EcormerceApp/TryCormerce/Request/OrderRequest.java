package com.example.EcormerceApp.TryCormerce.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String contactNumber;
    private  String region;
    private  String town;
    private  String paymentNumber;
    private double price;
    private double total;
    private double tax;
    private int quantity;
    private String productName;
}
