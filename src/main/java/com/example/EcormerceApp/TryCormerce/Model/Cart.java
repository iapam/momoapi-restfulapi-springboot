package com.example.EcormerceApp.TryCormerce.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="payment_sequence",sequenceName = "payment_sequence",allocationSize = 1)


    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String ontactNumber;
    private String region;
    private String town;
    private String paymentNumber;
    private double tax;
    private double total;
    private double price;
    private int quantity;
    private String productName;
    public Cart(String firstName,
                String lastName,
                String address,
                String ontactNumber,
                String region,
                String town,
                String paymentNumber,
                double tax,
                double price,
                double total,
                int quantity,
                String productName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ontactNumber = ontactNumber;
        this.region = region;
        this.town = town;
        this.paymentNumber = paymentNumber;
        this.tax=tax;
        this.price=price;
        this.total=total;
        this.quantity=quantity;
        this.productName=productName;
    }
}
